package com.self.entertainment.unclassified.mybatisinterceptor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AmazingZ
 * @date 2019/7/23 9:49
 */
public class InterceptorChain {

    /**
     * 放拦截器
     */
    private final List<Interceptor> interceptors = new ArrayList<Interceptor>();

    public Object pluginAll(Object target) {
        for (Interceptor interceptor : interceptors) {
            target = interceptor.plugin(target);
        }
        return target;
    }

    public void addInterceptor(Interceptor interceptor) {
        interceptors.add(interceptor);
    }
}
