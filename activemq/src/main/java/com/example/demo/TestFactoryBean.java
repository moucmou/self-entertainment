package com.example.demo;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author AmazingZ
 * @date 2019/7/1 18:37
 */
public class TestFactoryBean implements FactoryBean {

    private Class<?> type;
    @Override
    public Object getObject() throws Exception {
        return new TestDemo();
    }

    @Override
    public Class<?> getObjectType() {
        return TestDemo.class;
    }
}
