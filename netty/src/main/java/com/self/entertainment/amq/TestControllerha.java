package com.self.entertainment.amq;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestControllerha {

    @Autowired
    AmqConfig amqConfig;

    @RequestMapping(value = "/test")

    public String sayHello(String x){
        amqConfig.sayHello();
        return "";
    };
}
