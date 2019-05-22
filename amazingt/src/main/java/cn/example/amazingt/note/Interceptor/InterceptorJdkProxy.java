package cn.example.amazingt.note.Interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author AmazingZ
 * @date 2018/10/26 15:53
 */
public class InterceptorJdkProxy implements InvocationHandler {

    private Object target;
    private String interceptorClass=null;

    public InterceptorJdkProxy(Object target, String interceptorClass) {
        this.target = target;
        this.interceptorClass = interceptorClass;
    }

    public static Object bind(Object target,String interceptorClass){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().
                getInterfaces(),new InterceptorJdkProxy(target,interceptorClass));
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(interceptorClass ==null){
            return method.invoke(target,args);
        }
        Object result=null;
        Interceptor interceptor=(Interceptor)Class.forName(interceptorClass).newInstance();
        if(interceptor.before(proxy,target,method,args)){
            result= method.invoke(target,args);
        }else {
            interceptor.around(proxy,target,method,args);
        }
        interceptor.after(proxy,target,method,args);
        return result;
    }
}
