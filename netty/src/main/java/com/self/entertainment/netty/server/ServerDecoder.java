package com.self.entertainment.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author AmazingZ
 * @date 2019/7/31 9:40
 */
public class ServerDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        byte[] temp=new byte[in.readableBytes()];
        in.readBytes(temp);
        CustomerProtocol customerProtocol= new CustomerProtocol<>(temp.length, temp);
        out.add(customerProtocol);

    }
}
