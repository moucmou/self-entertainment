package com.self.entertainment.simple;

import java.io.IOException;
import java.io.OutputStream;

public class SimpleResponse  {
    private OutputStream outputStream;
    public SimpleResponse(OutputStream outputStream){
        this.outputStream = outputStream;
    }
    public  void  write(String content) throws IOException {
        /**
         * Http相应报文
         * @when
         */
        String httpResponse = "HTTP/1.1 200 OK\n" + "Content-Type:text/html\n" +
                "\r\n" + "<html><body>" + content +
                "</body><html>";
        outputStream.write(httpResponse.getBytes());
        outputStream.close();
    }
}
