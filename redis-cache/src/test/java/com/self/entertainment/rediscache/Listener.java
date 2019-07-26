package com.self.entertainment.rediscache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author AmazingZ
 * @date 2019/5/31 11:27
 */
@Component
@Slf4j
public class Listener implements ApplicationListener<TestEvent> {

    @Async
    @Override
    public void onApplicationEvent(TestEvent event) {
        log.info("i'm recive");
        try {
            Thread.sleep(1000 * 60 * 3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
