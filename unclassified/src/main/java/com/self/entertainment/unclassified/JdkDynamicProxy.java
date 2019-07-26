package com.self.entertainment.unclassified;

import org.springframework.aop.framework.AopProxy;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.util.Objects;

/**
 * @author AmazingZ
 * @date 2019/4/19 11:32
 */
@Component("TestI")
public class JdkDynamicProxy implements FactoryBean, AopTarget {

    @Override
    public Object getObject() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{TestI.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(getTarget(), args);
            }
        });
    }

    @Override
    public Class<?> getObjectType() {
        return TestI.class;
    }


    @Override
    public Object getTarget() {
        return new TestD();
    }

//    @Override
//    public String sayHello(String fuck) {
//        return ((TestI) Objects.requireNonNull(getObject())).sayHello("");
//    }
}
