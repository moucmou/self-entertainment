package com.self.entertainment.netty.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author AmazingZ
 * @date 2019/8/15 14:59
 */
public class FrameEncode extends MessageToByteEncoder<MessageProtocol> {


    @Override
    protected void encode(ChannelHandlerContext ctx, MessageProtocol msg, ByteBuf out) throws Exception {
        byte[] byteBody = msg.getPlayLoad().getBytes();
        ByteBuf header=Unpooled.buffer();
        header.writeInt(msg.getLength());
        ByteBuf body = Unpooled.wrappedBuffer(byteBody);
        out.writeBytes(Unpooled.wrappedBuffer(header, body));
    }
}
