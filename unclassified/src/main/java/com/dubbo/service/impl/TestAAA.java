package com.dubbo.service.impl;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author AmazingZ
 * @date 2019/5/13 11:30
 */
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
public class TestAAA {

    private String hello;
}
