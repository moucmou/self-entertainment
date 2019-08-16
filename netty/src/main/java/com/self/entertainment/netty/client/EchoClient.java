package com.self.entertainment.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import io.netty.util.AttributeKey;
import lombok.extern.slf4j.Slf4j;

import javax.net.ssl.SSLException;


/**
 * @author AmazingZ
 * @date 2019/5/27 10:02
 */
@Slf4j
public class EchoClient {


    static final boolean SSL = System.getProperty("ssl") != null;
    static final String HOST = System.getProperty("host", "127.0.0.1");
    static final int PORT = Integer.parseInt(System.getProperty("port", "8007"));
    static final int SIZE = Integer.parseInt(System.getProperty("size", "256"));

    public static void main(String[] args) throws SSLException, InterruptedException {
        // Configure SSL.git
        final SslContext sslCtx;
        if (SSL) {
            sslCtx = SslContextBuilder.forClient()
                    .trustManager(InsecureTrustManagerFactory.INSTANCE).build();
        } else {
            sslCtx = null;
        }
        /**
         * attr 追踪本地channel的属性，在本jvm内部使用
         */
        // Configure the client.
        String value = "lisi";
        AttributeKey<String> attributeKey = AttributeKey.valueOf("id");
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .attr(attributeKey, value)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline p = ch.pipeline();
                            if (sslCtx != null) {
                                p.addLast(sslCtx.newHandler(ch.alloc(), HOST, PORT));
                            }
                            p.addLast(new FrameEncode());
                            //p.addLast(new LoggingHandler(LogLevel.INFO));
//                            p.addLast(new EchoClientHandler());

                        }
                    });
            // Start the client.
            ChannelFuture f = b.connect(HOST, PORT).sync();
//            Unpooled.compositeBuffer().addComponents()
            f.channel().writeAndFlush(new MessageProtocol("niamde sasadddddddddddddddddddas")).
                    addListener(new ChannelFutureListener() {
                        @Override
                        public void operationComplete(ChannelFuture future) throws Exception {
                            System.out.println(future.isSuccess());
                        }
                    });
            f.channel().writeAndFlush(new MessageProtocol("ni21323mde sadas")).
                    addListener(new ChannelFutureListener() {
                        @Override
                        public void operationComplete(ChannelFuture future) throws Exception {
                            System.out.println(future.isSuccess());
                        }
                    });
            f.channel().writeAndFlush(new MessageProtocol("niamasdsade sadas")).
                    addListener(new ChannelFutureListener() {
                        @Override
                        public void operationComplete(ChannelFuture future) throws Exception {
                            System.out.println(future.isSuccess());
                        }
                    });
            f.channel().close();
            // Wait until the connection is closed.
            f.channel().closeFuture().sync();
        } finally {
            // Shut down the event loop to terminate all threads.
            group.shutdownGracefully();
        }

    }
}
