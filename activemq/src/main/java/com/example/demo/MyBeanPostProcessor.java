package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(@Nullable Object bean, String beanName) throws BeansException {
        log.info("BeanPostProcessor接口】调用postProcessBeforeInitialization方法，");
        return bean;
    }

    @Nullable
    public Object postProcessAfterInitialization(@Nullable Object bean, String beanName) throws BeansException {
        log.info("BeanPostProcessor接口】postProcessAfterInitialization，");
        return bean;
    }

}
