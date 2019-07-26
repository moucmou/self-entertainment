package com.example.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;

@Component
public class MyInstantiationAwareBeanPostProcessor  extends InstantiationAwareBeanPostProcessorAdapter {

    @Override
    public Object postProcessBeforeInstantiation(Class beanClass, String beanName) throws BeansException {
        System.out.println("【InstantiationAwareBeanPostProcessor接口】调用InstantiationAwareBeanPostProcessor接口的postProcessBeforeInstantiation方法");
        return null;
    }

    /**
     * 实例化Bean之后调用
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("【InstantiationAwareBeanPostProcessor接口】调用InstantiationAwareBeanPostProcessor接口的postProcessAfterInitialization方法");
        return bean;
    }

}
