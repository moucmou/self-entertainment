package com.self.entertainment;

import com.self.entertainment.config.SimpleRegistryService;
import entertainment.service.RestEasyService;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.curator.retry.RetryNTimes;
import org.apache.dubbo.common.URL;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
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

//        SimpleRegistryService.getInstance().register("server@justTest", URL.valueOf("rest://127.0.0.1:8090"));
        try (
                CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient("119.3.10.221:2181", new RetryNTimes(10, 5000));
        ) {
            curatorFramework.start();
            try {
//                curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath("/dubbo/server@justTest");
                curatorFramework.setData().forPath("/dubbo/server@justTest/providers","rest://127.0.0.1:8090".getBytes());
                curatorFramework.getData().usingWatcher(new CuratorWatcher() {
                    @Override
                    public void process(WatchedEvent event) throws Exception {

                        System.out.println("我被触发了吗" + event);
                    }
                }).forPath("/my/path/lock");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println();
        }
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
