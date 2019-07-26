package com.self.entertainment.unclassified.mybatisinterceptor;

/**
 * @author AmazingZ
 * @date 2019/7/23 9:50
 */
public class TestMain {

    public static void main(String[] args) {

        // 配置插件
        InterceptorChain interceptorChain = new InterceptorChain();
        interceptorChain.addInterceptor(new FirstInterceptor());
        interceptorChain.addInterceptor(new SecondInterceptor());

        // 获得代理对象
        IGetStr getStr = new GetStrImpl();
        getStr = (IGetStr) interceptorChain.pluginAll(getStr);

        String result = getStr.getStrZero();
        // plugin2 plugin1 0 plugin1 plugin2
        System.out.println(result);

        result = getStr.getStrOne();
        // 1
        System.out.println(result);
    }
}
