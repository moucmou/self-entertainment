package com.example.demo;

import org.springframework.stereotype.Component;

/**
 * @author AmazingZ
 * @date 2019/7/16 16:28
 */
@Component
public class TestServiceB {

    public TestServiceB() {
        System.out.println("循环依赖试试B");
    }
}
