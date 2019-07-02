package com.self.entertainment.rediscache.test;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author AmazingZ
 * @date 2019/7/2 16:49
 */
@RestController
public class TestController {

    @RequestMapping(value = "/index1", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "sayHello1")
    public String sayHello() {
        RestTemplate restTemplate = new RestTemplate();
        String object = restTemplate.getForObject("http://localhost:8080/testSleep", String.class);
        return "helloworld";
    }

    //    @RequestMapping(value = "/testSleep", method = RequestMethod.GET)
    public String testSleep() {
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "helloworld";
    }

    private String sayHello1() {
        return "faile say hello";
    }
}
