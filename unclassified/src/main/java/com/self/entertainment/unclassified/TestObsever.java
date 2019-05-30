package com.self.entertainment.unclassified;

import lombok.extern.slf4j.Slf4j;

import java.util.Observable;
import java.util.Observer;

/**
 * @author AmazingZ
 * @date 2019/5/30 10:15
 */
@Slf4j
public class TestObsever implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        log.info("i'm called" + o+"\r\n" +arg);
    }
}
