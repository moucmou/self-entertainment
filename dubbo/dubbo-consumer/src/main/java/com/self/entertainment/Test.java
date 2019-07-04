package com.self.entertainment;

import com.self.entertainment.config.SimpleRegistryService;
import entertainment.service.RestEasyService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author AmazingZ
 * @date 2019/5/28 16:18
 */
@Slf4j
@Component
public class Test implements ApplicationListener<ContextRefreshedEvent> {
    //    @Autowired
//    HelloService helloService;
    @Autowired
    TestRestEasyService testRestEasyService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        SimpleRegistryService.getInstance().register("server@justTest", URL.valueOf("rest://127.0.0.1:8090"));

        new Thread(() -> {
            testRestEasyService.echo("2313123");
            try {
                Thread.sleep(3 * 1000 * 60);
            } catch (InterruptedException e) {
                log.error("", e);
            }
            log.info("我开始了");
//            helloService.sayHello();
        }).start();

    }
}
