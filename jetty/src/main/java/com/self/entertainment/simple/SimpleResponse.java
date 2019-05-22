package com.self.entertainment.simple;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
@Slf4j
@Data
@AllArgsConstructor
public class SimpleResponse {

    private SocketChannel socketChannel = null;
    public  void write(String content) {
        String httpResponse = "HTTP/1.1 200 OK\n" + "Content-Type:text/html\n" +
                "\r\n" + "<html><body>" + content +
                "</body><html>";
        ByteBuffer byteBuffer=ByteBuffer.wrap(httpResponse.getBytes(StandardCharsets.UTF_8));
        try {
            socketChannel.write(byteBuffer);
        } catch (IOException e) {
            log.error("写流失败",e);
        }
    }

}
