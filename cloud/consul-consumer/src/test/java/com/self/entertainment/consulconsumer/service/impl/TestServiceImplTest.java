package com.self.entertainment.consulconsumer.service.impl;

import com.self.entertainment.consulconsumer.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author AmazingZ
 * @date 2019/9/17 20:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceImplTest {

    @Autowired
    TestService testService;
    @Test
    public void test1(){
       String echo= testService.echo("hello world");
        System.out.println();
    }

}