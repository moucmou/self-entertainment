package cn.example.amazingt.note.socket;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.time.LocalTime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;

/**
 * @author AmazingZ
 * @date 2018/11/6 10:28
 */
public class PlainOioServerThread implements Runnable {
    private Socket socket;

    //同一IP只允许一个链接的Map
    public static final ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<String, Long>();

    public PlainOioServerThread(Socket socket) {
        this.socket = socket;
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ServerSocket serverSocket = new ServerSocket(9120);
                    try {
                        System.out.println("Socket服务端已启动，等待客户端连接......");
                        while (true) {
                            // 侦听并接受到此套接字的连接，返回一个Socket对象
                            Socket socket = serverSocket.accept();
                            socket.setTcpNoDelay(true);
                            PlainOioServerThread socketThread = new PlainOioServerThread(socket);
                            Executors.newFixedThreadPool(5).submit(socketThread);
                        }
                    } finally {
                        //释放资源回收
                        if (serverSocket != null) {
                            serverSocket.close();
                        }
                    }
                } catch (Exception e) {
                    System.out.println("初始化Socket服务失败");
                }
            }
        }).start();
    }

    @Override
    public void run() {
        if (socket == null || socket.getInetAddress() == null) {
            System.out.println("请求参数有误，socket为空或客户端Address为空");
            return;
        }
        String ipAndPort = socket.getInetAddress().getHostAddress() + "-" + socket.getPort();
        //判断是否为相同ip链接，如果是，挤掉该ip之前的链接
        Long socketStatus = map.get(socket.getInetAddress().getHostAddress());
        while (socketStatus != null && socketStatus == 1) {
            try {
                //服务端断开与该ip的链接状态为已断开，服务端主动断开无效的客户端链接
                map.put(socket.getInetAddress().getHostAddress(), 0L);
                //等待1s
                Thread.sleep(1000);
                socketStatus = map.get(socket.getInetAddress().getHostAddress());
            } catch (InterruptedException e) {
                System.out.println("暂停等待客户端的连接失败，客户端信息IP和PORT为：" + ipAndPort);
            }
        }
        map.put(socket.getInetAddress().getHostAddress(), 1L);
        System.out.println("socket开启连接成功，当前客户端信息IP和PORT为：{}" + ipAndPort);
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        OutputStream outputStream = null;
        PrintWriter printWriter = null;
        try {
            try {
                inputStream = socket.getInputStream();
                // 得到一个输入流，接收客户端传递的信息
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");// 提高效率，将字节流转为字符流
                bufferedReader = new BufferedReader(inputStreamReader);// 加入缓冲区
                while (true) {
                    //链接状态已断开
                    socketStatus = map.get(socket.getInetAddress().getHostAddress());
                    if (socketStatus != 1L) {
                        break;
                    }
                    if (socket.isClosed() || !socket.isConnected()) {
                        System.out.println("客户端：{}已经主动断开连接:" + ipAndPort);
                        break;
                    }
                    if (bufferedReader.ready()) {
                        String msg = bufferedReader.readLine();
//                        new Thread(new Runnable() {
//                            @Override
//                            public void run() {
//                                try {
//                                 PrintWriter printWriter=   new PrintWriter(socket.getOutputStream());
//                                 printWriter.print("receive message success\n");
//                                 printWriter.flush();
//                                 Thread.sleep(5);
//                                } catch (IOException e) {
//                                    e.printStackTrace();
//                                } catch (InterruptedException e) {
//                                    e.printStackTrace();
//                                }
//
//                            }
//                        }).start();
                        if (msg == null) {
                            break;
                        } else if (msg.startsWith("heartbeat")) {
                            System.out.println(Thread.currentThread().getName() + "，服务端接收到客户端：{}的信息为：{}" + ipAndPort + "," + msg);
//                            socket.getOutputStream().write("heartbeat !!".getBytes(Charset.forName("UTF-8")));
//                            outputStream = socket.getOutputStream();// 获取一个输出流，向服务端发送信息
//                            printWriter = new PrintWriter(outputStream);// 将输出流包装成打印流
//                            printWriter.print("heartbeatjkdhaskjdhksadsajdaskasd!\n\n");
//                            printWriter.flush();
                            System.out.println(LocalTime.now().toString());

                        } else {
                            System.out.println(Thread.currentThread().getName() + "，服务端接收到客户端：{}的信息为：{}" + ipAndPort + "," + msg);
                            //防止处理时间过长，导致客户端需要等待，使用异步执行
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    System.out.println("info:" + msg);
                                }
                            }).start();

//                            outputStream = socket.getOutputStream();// 获取一个输出流，向服务端发送信息
//                            printWriter = new PrintWriter(outputStream);// 将输出流包装成打印流
//                            printWriter.print("receive message success\n");
//                            printWriter.flush();
                        }
                    }
                }
            } finally {
                System.out.println("socket断开连接成功，当前客户端为：{}" + ipAndPort);
                if (!socket.isClosed() && socket.isConnected()) {
                    socket.shutdownOutput();// 关闭输出流
                }
                // 关闭相对应的资源
                IOUtils.closeQuietly(bufferedReader);
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly(printWriter);
                IOUtils.closeQuietly(outputStream);

            }
        } catch (Exception e) {
            System.out.println("处理socket消息失败，客户端ip为：{}" + socket.getInetAddress().getHostAddress() + ",");
            e.printStackTrace();
        }

    }
}
