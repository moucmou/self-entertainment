package com.self.entertainment;

import entertainment.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class DubboConsumerApplication {
    @Reference
    HelloService helloService;
    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplication.class, args
        );
    }

    @Bean
    public ApplicationRunner runner() {
        return args -> {
            log.info(helloService.sayHello());
        };
    }

}
