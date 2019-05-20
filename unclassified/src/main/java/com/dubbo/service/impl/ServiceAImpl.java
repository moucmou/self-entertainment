package com.dubbo.service.impl;

import com.dubbo.service.ServiceA;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author AmazingZ
 * @date 2019/5/13 11:01
 */
@Service
public class ServiceAImpl implements ServiceA {
    @Override
    public String sayHello() {
        return "hello world";
    }
}
