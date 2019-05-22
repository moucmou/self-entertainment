package note.socket;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author AmazingZ
 * @date 2018/11/6 10:27
 */
public class PlainIOClient {
    public LocalTime getLastTime() {
        return lastTime;
    }

    public void setLastTime(LocalTime lastTime) {
        this.lastTime = lastTime;
    }

    private LocalTime lastTime=LocalTime.now();
    private Socket socket;
    private int port;
    private String host;
    private OutputStream outputStream;
    private InputStream inputStream;

    public PlainIOClient( int port, String host) {
        this.port = port;
        this.host = host;
    }
    public void init() throws IOException {
        try {
            this.socket= new Socket();
            socket.connect(new InetSocketAddress("localhost", 9120), 2000);
            socket.setKeepAlive(true);
//            socket.setSoTimeout(2000);

        }catch (Exception e){
            System.out.println(e);
        }
        this.outputStream=this.socket.getOutputStream();
        this.inputStream=this.socket.getInputStream();
        System.out.println("初始化完毕");
    }
    public void sendMsg(byte[] x) throws IOException {
        outputStream.write(x);
        lastTime=LocalTime.now();
    }
    public void getMsg() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);// 加入缓冲区
//        LocalTime.now().minusSeconds(6L).isBefore(lastTime)

        for( ;LocalTime.now().minusSeconds(50L).isBefore(lastTime);) {

            if (bufferedReader.ready()) {

                String msg = bufferedReader.readLine();
                System.out.println(lastTime.toString());
                System.out.println(LocalTime.now().toString());
                if (msg == null) {
                    break;
                } else if (msg.startsWith("heartbeat")) {
                    System.out.println("do noting");
                } else {
                    lastTime = LocalTime.now();
                    System.out.println("do somthing ! " + msg);
                }
                lastTime = LocalTime.now();
            }

        }
        refresh();


    }
    public void refresh() throws IOException {
        destroy();
        init();
        getMsg();
    }
    public void destroy(){
        try {

//            IOUtils.closeQuietly(inputStream);
//            IOUtils.closeQuietly(outputStream);
            System.out.println("销毁");
            socket.close();
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws InterruptedException, IOException {

//        PlainIOClient plainIOClient= new PlainIOClient(9120,"localhost");
//        plainIOClient.init();
//        plainIOClient.outputStream.write("hello".getBytes(Charset.forName("UTF-8")));
//        PlainIOClient plainIOClient= new PlainIOClient(9120,"localhost");
//        plainIOClient.init();
//        Thread t=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(;;){
//
//                }
//            }
//        });
//        t.start();
//        t.join();

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
////        CyclicBarrier cyclicBarrier=new CyclicBarrier(1, new Runnable() {
////            @Override
////            public void run() {
////                try {
////                    Thread.sleep(3*1000);
////                    InputStream in= plainIOClient.inputStream;
////                    byte[] bytes = new byte[in.available()];
////                    int length = in.read(bytes);
////                    System.out.println("Server say: " + new String(bytes, Charset.forName("UTF-8")));
////                } catch (InterruptedException | IOException e) {
////                    e.printStackTrace();
////                }
////            }
////        });
//
        PlainIOClient plainIOClient= new PlainIOClient(9120,"localhost");
        plainIOClient.init();
        executorService.scheduleWithFixedDelay(new Runnable() {
            private boolean isconnected=true;
            int count=0;
            @Override
            public void run() {
                //                    cyclicBarrier.reset();
//                if (isconnected && LocalTime.now().minusSeconds(5).isAfter(plainIOClient.getLastTime())) {
                    System.out.println(LocalTime.now().toString());
                    try {
                        System.out.println(count++);
//                        PlainIOClient plainIOClient= new PlainIOClient(9120,"localhost");
//                        plainIOClient.init();
//                        plainIOClient.outputStream.write("hello".getBytes(Charset.forName("UTF-8")));
                        String x="heartbeatjkdhaskjdhksadsajdaskasd"+count+"\r\n";
                        plainIOClient.sendMsg(x.getBytes(Charset.forName("UTF-8")));
//
//                        plainIOClient.setLastTime(LocalTime.now());
//                        count++;
//                        if(count==1000){
////                            Thread.sleep(1*1000);
//                        }
//                        System.out.println(count);

                    }catch (IOException e){
                        System.out.println(LocalTime.now().toString());
                        System.out.println(e);
//                        isconnected=false;
//                        plainIOClient.destroy();
                    }
//                        cyclicBarrier.await();
//                }
//                while(!isconnected){
//                    System.out.println("掉线了 重连中");
//                    try{
////                        plainIOClient.init();
//                        System.out.println("重连成功");
//                        isconnected=true;
//                    }catch (IOException e){
//                        System.out.println("重连失败"+e);
//                    }
//                }

            }
        }, 0, 20,TimeUnit.MILLISECONDS);

//        plainIOClient.sendMsg(("asdasd asdsa sdadasd!\r\n").getBytes(Charset.forName("UTF-8")));
//        plainIOClient.getMsg();
//        Thread.sleep(10000);
//        plainIOClient.getMsg();

    }
}
