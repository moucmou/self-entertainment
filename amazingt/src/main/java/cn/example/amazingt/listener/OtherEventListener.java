package cn.example.amazingt.listener;

import cn.example.amazingt.events.OtherEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author AmazingZ
 * @date 2018/9/16 20:14
 */

/**
 * 订阅者
 */
@Component
public class OtherEventListener implements ApplicationListener<OtherEvent> {

    private Logger logger = LoggerFactory.getLogger(OtherEventListener.class);
    private final String[] blackIp = {
            "10.10.10.10",
            "11.11.11.11"
    };

    /**
     * 其他类型事件的监听器
     * 比如统计有没有在黑名单里的ip
     *
     * @param event
     */
    @Override
    public void onApplicationEvent(OtherEvent event) {

        if (Arrays.asList(blackIp).contains(event.getIp())) {
            logger.info(event.getIp() + "这个黑名单设备又来了");
        }
    }
}
