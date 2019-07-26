package com.self;

import com.self.entertainment.TestRestEasyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@Slf4j
@ImportResource(locations = {"classpath:consumer.xml"})
public class DubboConsumerApplication {
    @Autowired
    TestRestEasyService testRestEasyService;
//    @Autowired
//    HelloService helloService;
    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplication.class, args);

        System.out.println();
    }


}
