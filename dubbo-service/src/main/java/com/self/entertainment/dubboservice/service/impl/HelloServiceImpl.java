package com.self.entertainment.dubboservice.service.impl;

import com.self.entertainment.dubboservice.service.HelloService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author AmazingZ
 * @date 2019/5/21 10:04
 */
@Service
public class HelloServiceImpl implements HelloService {


    @Override
    public String sayHello() {
        return "helloWorld";
    }
}
