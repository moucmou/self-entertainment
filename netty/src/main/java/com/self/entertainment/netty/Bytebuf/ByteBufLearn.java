package com.self.entertainment.netty.Bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.util.ReferenceCountUtil;
import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author AmazingZ
 * @date 2019/8/14 10:59
 */
public class ByteBufLearn {
    public static void main(String[] args) {
        ByteBuf byteBuf = Unpooled.copiedBuffer("123", Charset.forName("utf-8"));
        int readerIndex = byteBuf.readerIndex();
        int writerIndex = byteBuf.writerIndex();
        /**
         * get&set不会修改读写index的值
         * write&read才会修改index的值
         * 这样就会把消息追加进这个bytebuf里
         */
        byteBuf.writeCharSequence("123", Charset.forName("utf-8"));
        System.out.println();
        /**
         * 引用计数器，比价老的回收思想吧，不能释放解决循环依赖但没有再用的引用
         */
        ByteBuf byteBuf1 = Unpooled.buffer();
        /**
         * 引用数应该为1
         */
        byteBuf1.refCnt();
        byteBuf1.release();
        ByteBuf byteBuf2 = Unpooled.directBuffer();
        /**
         * directBytebuf 是有自己去清理直接内存的
         */
//        byteBuf2.release();
        /**
         * 切片跟复制不一样的  复制是另外一个支撑数组了，切片还是原来那个数组的引用只是被切片了
         */
        byteBuf2.slice();
        byteBuf2.copy();
        System.out.println();
        /**
         * 工具类手动调用释放资源
         */
        ReferenceCountUtil.release(byteBuf2);

        new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                /**
                 * 针对某个channel获取其绑定的eventloop线程
                 */
//                ch.eventLoop().schedule()
                ChannelPipeline channelPipeline = ch.pipeline();
                /**
                 * 注意直接滴啊用channelpipeline和调用具体的 *boundhander的区别
                 * 直接调用c
                 * ..hannelpipeline的方法走完整个pipline，而调用某个具体的bounder里面的channelhandercontext
                 * 只会调用下一个channelhanler的方法
                 *
                 */
//                channelPipeline.fireChannelRead(new Object());
                channelPipeline.addLast(new ChannelOutboundHandlerAdapter() {
                });
            }
        };
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        }, 60, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
        /**
         * 流式语法？  public abstract class AbstractBootstrap<B extends AbstractBootstrap<B, C>, C extends Channel>
         *    子类型B是其父类型的一个类型参数，可以返回到运行时实例的引用 父类利用泛型参数可以动态获取其具体实现类
         */

    }

    public static class A implements Serializable {
        private static final long serialVersionUID = 5933553000193722137L;
        private String x;

        public A(String x) {
            this.x = x;
        }

        public String getX() {
            return x;
        }

        public void setX(String x) {
            this.x = x;
        }
    }

    @Test
    public void testFrameDecoded() {
        ByteBuf buf = Unpooled.buffer();
        for (int i = 0; i < 9; i++) {
            buf.writeByte(i);
        }
        buf.writeCharSequence("00015161561", Charset.forName("utf-8"));
        ByteBuf input = buf.duplicate();
        EmbeddedChannel embeddedChannel = new EmbeddedChannel(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 2));
        boolean condition = embeddedChannel.writeInbound(input.readBytes(9));
    }

    /**
     * 往writeOutbound 会倒序处理outboundhandler，然后readoutbound获取bytebuf,写入到inbound，正序处理inbounhandler
     *
     * @throws IOException
     */
    @Test
    public void testPojoSerializable() throws IOException {
        A a = new A("21352163");
        EmbeddedChannel embeddedChannel = new EmbeddedChannel(new ObjectEncoder(), new ObjectDecoder(ClassResolvers.cacheDisabled(null)), new SimpleChannelInboundHandler() {

            @Override
            protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
                A a = (A) msg;
                System.out.println();
            }
        });
        embeddedChannel.writeOutbound(a);
        ByteBuf bytebuf = embeddedChannel.readOutbound();
        embeddedChannel.writeInbound(bytebuf);
    }

    /**
     * 往inbound写是测试入栈处理器  往outbound写是处理出栈处理器  往channel里写入bytebuf
     *
     * @throws IOException
     */
    @Test
    public void testPojoSerializable1() throws IOException {
        A a = new A("21352163");
        EmbeddedChannel embeddedChannel = new EmbeddedChannel(new ObjectDecoder(ClassResolvers.cacheDisabled(null)));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(a);
        objectOutputStream.flush();
        ByteBuf byteBuf = Unpooled.wrappedBuffer(byteArrayOutputStream.toByteArray());
        embeddedChannel.writeInbound(byteBuf);
    }

    /**
     * 使用DefaultFileRegion 直接进行文件块传输
     * @throws IOException
     */
    @Test
    public void testFileRegion() throws IOException {
//        EmbeddedChannel embeddedChannel = new EmbeddedChannel(new ChannelInboundHandlerAdapter());
        RandomAccessFile randomAccessFile=new RandomAccessFile("C:\\Users\\zhutao14\\Desktop\\zzzzzzzzzzz\\111.txt","rw");
//        embeddedChannel.writeInbound(new DefaultFileRegion(randomAccessFile.getChannel(),0,randomAccessFile.length()));
        long currentPoint= randomAccessFile.getFilePointer();
        randomAccessFile.seek(currentPoint);

    }
}
