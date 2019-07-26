package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author AmazingZ
 * @date 2019/7/16 16:28
 */
@Component
public class TestServiceA {

    public TestServiceA() {
        System.out.println("循环依赖试试A");
    }
}
