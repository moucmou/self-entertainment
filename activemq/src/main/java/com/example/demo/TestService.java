package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author AmazingZ
 * @date 2019/7/16 13:40
 */
@Component
public class TestService {
    @Autowired
    TestServiceB testServiceA;

    public TestService() {
        System.out.println("我只是一个普通的bean,我想知道我什么时候被放到beandefitionmap");
    }
}
