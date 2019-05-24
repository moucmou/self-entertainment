package com.self.entertainment.unclassified;

import org.apache.log4j.net.SocketServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * @author AmazingZ
 * @date 2019/5/21 16:52
 */
public class NioSocketClient {

    public static void main(String[] args) {

        for (int i = 0; i < 100000; i++) {
            try (SocketChannel socketChannel = SocketChannel.open();
                 Selector selector = Selector.open();
            ) {
                socketChannel.connect(new InetSocketAddress(9171));
                socketChannel.configureBlocking(false);
                socketChannel.register(selector, SelectionKey.OP_READ);
                String message = "hello world \r\n";
                ByteBuffer byteBuffer = ByteBuffer.wrap(message.getBytes());
                socketChannel.write(byteBuffer);
//            while (selector.select()>0){
//                Iterator<SelectionKey> iterator=selector.keys().iterator();
//                while (iterator.hasNext()){
//                    SelectionKey selectionKey = iterator.next();
//                    iterator.remove();
//                    SocketChannel client=(SocketChannel)selectionKey.channel();
//                    if(selectionKey.isReadable()){
//                        ByteBuffer byteBuffer1=ByteBuffer.allocate(1024);
//                        while (client.read(byteBuffer1)!=-1){
//                            byteBuffer1.flip();
//                            System.out.println(new String(byteBuffer1.array()));
//                        }
//                    }
//
//                }
//            }
                System.out.println(i);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
