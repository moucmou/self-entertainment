package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
public class TestBean implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware {

    private String name;
    @Autowired
    TestDemo testDemo;

    public TestBean() {
        log.info("TestBean 构造方法初始化");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("beanFactory set 方法");
    }

    @Override
    public void setBeanName(String name) {
        log.info("setBeanName什么卵方法");

    }

    @Override
    public void destroy() throws Exception {
        log.info("destroy 容器销毁后执行");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("bean初始化之后的调用");
    }

    @PostConstruct
    public void postConstruct() {
        log.info("InitSequenceBean: postConstruct");
    }

    @PreDestroy
    public void destory() {
        log.info("InitSequenceBean: destory");
    }

    public void initMethod() {
        log.info("InitSequenceBean: initMethod");
    }
}
