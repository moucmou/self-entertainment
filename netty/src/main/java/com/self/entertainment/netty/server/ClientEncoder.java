package com.self.entertainment.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author AmazingZ
 * @date 2019/7/31 10:28
 */
public class ClientEncoder extends MessageToByteEncoder {

    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {

        System.out.println();
    }

    public static void main(String[] args) {
        CompositeByteBuf compositeByteBuf = Unpooled.compositeBuffer();
        compositeByteBuf.writeBytes("helloworld".getBytes());
        ByteBuf byteBuf = Unpooled.compositeBuffer();
        byte[] zz=new byte[3];
        compositeByteBuf.readBytes(zz,0,3);
        compositeByteBuf.readBytes(zz,0,3);
    }
}
