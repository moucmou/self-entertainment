package com.self.entertainment.unclassified;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.util.Iterator;

/**
 * @author AmazingZ
 * @date 2019/5/21 16:56
 */
public class NioSocketServer implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(NioSocketServer.class);

    public static void main(String[] args) throws IOException {
        try (
                ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
                Selector selector = Selector.open();
        ) {
            serverSocketChannel.socket().bind(new InetSocketAddress(9171));
            serverSocketChannel.socket().setReuseAddress(true);
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (selector.select() > 0) {
                Iterator<SelectionKey> selectionKeys = selector.selectedKeys().iterator();
                while (selectionKeys.hasNext()) {
                    SelectionKey selectionKey = selectionKeys.next();
                    if (selectionKey.isAcceptable()) {
                        ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
                        SocketChannel socketChannel = server.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);
                        logger.info(socketChannel.getLocalAddress() + "\n" + socketChannel.getRemoteAddress());
                    }
                    if (selectionKey.isReadable()) {
                        try (FileChannel dst = FileChannel.open(Paths.get("C:\\Users\\zhutao14\\Desktop\\socket\\sourceDst.txt"))) {
                            SocketChannel client = (SocketChannel) selectionKey.channel();
                            ByteBuffer receivebuffer = ByteBuffer.allocate(1024);
                            while (client.read(receivebuffer) > 0) {
                                receivebuffer.flip();
                                System.out.println(new String(receivebuffer.array()));
                                receivebuffer.rewind();
                                dst.write(receivebuffer);
                            }
                            if (client.read(receivebuffer) < 0) {
                                client.close();
                            }
                        } catch (Exception e) {
                            logger.error("",e);
                        }
                    }

                }
                selectionKeys.remove();
            }

        } catch (IOException e) {
            logger.error("出错了", e);
        }
    }

    @Override
    public void run() {

    }
}
