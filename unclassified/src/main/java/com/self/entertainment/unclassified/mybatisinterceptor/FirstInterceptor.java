package com.self.entertainment.unclassified.mybatisinterceptor;

/**
 * @author AmazingZ
 * @date 2019/7/23 9:46
 */
public class FirstInterceptor implements Interceptor {
    @Override
    public Object interceptor(Invocation invocation) {
        try {
            return "plugin1 " + invocation.proceed() + " plugin1";
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }
}
