package cn.example.amazingt.note.Interceptor;

import cn.example.amazingt.note.Interceptor.Interceptor;

import java.lang.reflect.Method;

/**
 * @author AmazingZ
 * @date 2018/10/26 15:51
 */
public class MyInterceptor implements Interceptor {
    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("反射方法前逻辑");
        return true;
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("取代了被代理的方法");
    }

    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("反射方法后逻辑");

    }
}
