package com.example.demo;

import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;

import java.util.Properties;

/**
 * @author AmazingZ
 * @date 2019/7/1 15:25
 */
@Configuration
public class TestConfig {

    @Bean
    PropertySourceLocator propertySourceLocator(){
        return environment -> {
            System.out.println("我是环境配置量");
            Properties localConfig = new Properties();

            localConfig.setProperty("spring.activemq.broker-url","helloworld");
            return new PropertiesPropertySource("123",localConfig);
        };
    }

}
