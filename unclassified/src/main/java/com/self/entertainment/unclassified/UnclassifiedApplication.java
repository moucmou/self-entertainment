package com.self.entertainment.unclassified;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class UnclassifiedApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnclassifiedApplication.class, args);
//        new SpringApplicationBuilder(UnclassifiedApplication.class)
//                .listeners((ApplicationListener<ApplicationEnvironmentPreparedEvent>) new ApplicationListener<ApplicationEnvironmentPreparedEvent>() {
//                    @Override
//                    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
//                        Environment environment = event.getEnvironment();
//                        int port = environment.getProperty("embedded.zookeeper.port", int.class);
//                        new EmbeddedZooKeeper(port, false).start();
//                    }
//                })
//                .run(args);
    }

}
