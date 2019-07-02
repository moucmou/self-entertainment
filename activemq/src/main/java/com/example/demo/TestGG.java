package com.example.demo;

import com.example.amq.AmqListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author AmazingZ
 * @date 2019/7/1 15:04
 */
@Configuration
@ComponentScan
@Import({TestSelector.class,TestImportBeanDefinitionRegistrar.class})
public class TestGG {

    public TestGG(){
        System.out.println("helloWord");
    }

//    @Bean
//    public TestConfig testConfig(){
//        return new TestConfig();
//    }
}
