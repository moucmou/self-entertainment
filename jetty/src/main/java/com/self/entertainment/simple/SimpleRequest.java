package com.self.entertainment.simple;

import java.io.IOException;
import java.io.InputStream;

public class SimpleRequest {
    private  String url;
    private  String method;
    public SimpleRequest(InputStream inputStream) throws IOException {
        String httpRequest = "";
        byte[] httpRequestBytes = new byte[1024];
        int length = 0;
        if (0<(length = inputStream.read(httpRequestBytes))){
            httpRequest = new String(httpRequestBytes , 0 ,length);
        }
        //http 请求报文
        System.out.println("HTTP请求报文:\n"+httpRequest);
        //通过字符串截取URL和请求方法
        String httpHead = httpRequest.split("\n")[0];
        method = httpHead.split("\\s")[0];
        url = httpHead.split("\\s")[1];

        System.out.println(this);
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
