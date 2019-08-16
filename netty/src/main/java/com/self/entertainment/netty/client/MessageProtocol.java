package com.self.entertainment.netty.client;

/**
 * @author AmazingZ
 * @date 2019/8/15 14:53
 */
public class MessageProtocol {

    private String playLoad;

    public MessageProtocol(String playLoad) {
        this.playLoad = playLoad;
    }

    public String getPlayLoad() {
        return playLoad;
    }

    public void setPlayLoad(String playLoad) {
        this.playLoad = playLoad;
    }

    public int getLength() {
        return playLoad.length();
    }

}
