package com.self.entertainment.unclassified.mybatisinterceptor;

/**
 * @author AmazingZ
 * @date 2019/7/23 9:38
 */
public interface Interceptor {

    Object interceptor(Invocation invocation);

    Object plugin(Object target);
}
