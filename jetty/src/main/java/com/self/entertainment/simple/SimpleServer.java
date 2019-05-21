package com.self.entertainment.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.nio.channels.ServerSocketChannel;

public class SimpleServer {

    private static final Logger logger = LoggerFactory.getLogger(SimpleServer.class);
    private Map<String, String> urlServletMap = new ConcurrentHashMap<>();

    public void init() {
        initServletMapping();
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
             Selector selector = Selector.open();
        ) {
            serverSocketChannel.socket().bind(new InetSocketAddress(8080));
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    iterator.remove();
                    if (selectionKey.isAcceptable()) {
                        ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
                        SocketChannel socketChannel = server.accept();
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    }
                    if (selectionKey.isReadable()) {

                        try (SocketChannel client = (SocketChannel) selectionKey.channel();
                        ) {
                            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                            while (client.read(byteBuffer) > 0) {
                                byteBuffer.flip();
                            }
                            if (client.read(byteBuffer)==-1) {
                                selectionKey.cancel();

                            }
                        } catch (Exception e) {
                            logger.error("读出错", e);
                        }

                    }
                }
            }


        } catch (Exception e) {
            logger.error("", e);
        }
    }

    /**
     * 初始化Map
     *
     * @when
     */
    private void initServletMapping() {
        for (ServletMapping servletMapping : ServletMappingConfig.servletMappingList) {
            urlServletMap.put(servletMapping.getUrl(), servletMapping.getClazz());
        }
    }
}
