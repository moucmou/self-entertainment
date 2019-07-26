package com.self.entertainment.unclassified.mybatisinterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author AmazingZ
 * @date 2019/7/23 9:42
 */
public class Plugin implements InvocationHandler {

    private final Object target;

    private final Interceptor interceptor;

    public Plugin(Object target, Interceptor interceptor) {
        this.target = target;
        this.interceptor = interceptor;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 只为方法getStrZero生成代理对象
        if (method.getName().equals("getStrZero")) {
            return interceptor.interceptor(new Invocation(target, method, args));
        }
        return method.invoke(target, args);
    }

    public static Object wrap(Object object, Interceptor interceptor) {

        return Proxy.newProxyInstance(object.getClass().getClassLoader(),
                new Class[]{IGetStr.class}, new Plugin(object, interceptor));
    }
}
