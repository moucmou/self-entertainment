package com.self.entertainment.unclassified.mybatisinterceptor;

/**
 * @author AmazingZ
 * @date 2019/7/23 9:48
 */
public class SecondInterceptor implements Interceptor {

    @Override
    public Object interceptor(Invocation invocation) {
        try {
            return "plugin2 " + invocation.proceed() + " plugin2";
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }
}
