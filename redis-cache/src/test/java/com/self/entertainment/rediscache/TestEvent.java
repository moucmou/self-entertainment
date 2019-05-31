package com.self.entertainment.rediscache;

import org.springframework.context.ApplicationEvent;

/**
 * @author AmazingZ
 * @date 2019/5/31 11:25
 */
public class TestEvent extends ApplicationEvent {
    private static final long serialVersionUID = 7216032541446962877L;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public TestEvent(Object source) {
        super(source);
    }
}
