package com.self.entertainment.simple;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.io.IOUtils;

@Slf4j
public class SimpleServer {

    private static final Logger logger = LoggerFactory.getLogger(SimpleServer.class);
    private Map<String, String> urlServletMap = new ConcurrentHashMap<>();

    public void init() {
        initServletMapping();
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
             Selector selector = Selector.open();
        ) {
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(8080));
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (selector.select() > 0) {
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    iterator.remove();
                    if (selectionKey.isAcceptable()) {
                        ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
                        SocketChannel socketChannel = server.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    }
                    if (selectionKey.isReadable()) {
                        try (SocketChannel client = (SocketChannel) selectionKey.channel();
                        ) {
//                            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
//                            while (client.read(byteBuffer) > 0) {
//                                byteBuffer.flip();
//                            }
//                            ;SimpleRequest.of(new ByteInputStream(byteBuffer.array(), byteBuffer.array().length))
                            dispatch(Objects.requireNonNull(SimpleRequest.of(client)), new SimpleResponse(client));
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

    private void dispatch(SimpleRequest simpleRequest, SimpleResponse simpleResponse) {
        String clazz = urlServletMap.get(simpleRequest.getUrl());
        if (clazz == null) {
            log.info("找不到该url对应的处理类");
        }
        //反射
        try {
            AbstractServlet abstractServlet = (AbstractServlet) Class.forName(clazz).newInstance();
            abstractServlet.service(simpleRequest, simpleResponse);
        } catch (Exception e) {
            log.error("反射创建实例失败", e);
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

    public static void main(String[] args) {
        new SimpleServer().init();
    }
}
