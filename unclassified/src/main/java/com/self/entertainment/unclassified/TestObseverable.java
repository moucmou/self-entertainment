package com.self.entertainment.unclassified;

import lombok.extern.slf4j.Slf4j;

import java.util.Observable;

/**
 * @author AmazingZ
 * @date 2019/5/30 10:16
 */
@Slf4j
public class TestObseverable  extends Observable {

    public void setChange(){
        super.setChanged();
    }
    public static void main(String[] args) {
        TestObseverable observable=new TestObseverable();
        observable.setChange();
        observable.addObserver(new TestObsever());
        observable.notifyObservers("helloworld");
        log.info("");
    }
}
