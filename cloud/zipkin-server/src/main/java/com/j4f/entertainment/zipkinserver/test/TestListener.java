package com.j4f.entertainment.zipkinserver.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author AmazingZ
 * @date 2019/9/19 10:19
 */
//@Component
public class TestListener implements SmartApplicationListener {
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return true;
    }

    @Value("${management.metrics.web.server.auto-time-requests}")
    private Boolean x;
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println();
    }
}
