package com.self.entertainment.simple;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class SimpleRequest {
    private Logger logger = LoggerFactory.getLogger(SimpleRequest.class);
    private String url;
    private String method;

    public SimpleRequest(InputStream inputStream) throws IOException {
        String httpRequest = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        logger.info(httpRequest);
        //通过字符串截取URL和请求方法
        String httpHead = httpRequest.split("\n")[0];
        method = httpHead.split("\\s")[0];
        url = httpHead.split("\\s")[1];
    }

    public static SimpleRequest of(SocketChannel client) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        ByteArrayInputStream byteInputStream = null;
        while (client.read(byteBuffer) > 0) {
            byteBuffer.flip();
            byteInputStream = new ByteArrayInputStream(byteBuffer.array(), 0, byteBuffer.remaining());
            byteBuffer.clear();
        }
        try {
            return new SimpleRequest(byteInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String toString() {
        return "MyRequest [url=" + url + ", method=" + method + "]";
    }
}
