package com.self.entertainment.netty.server;

/**
 * @author AmazingZ
 * @date 2019/7/31 9:43
 */
public class CustomerProtocol<T> {
    private int length;
    private T data;

    public CustomerProtocol() {
    }

    public CustomerProtocol(int length, T data) {
        this.length = length;
        this.data = data;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
