package com.feign.custom;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.Server;

/**
 * @author: zhutao
 * @date: 2020/10/20 6:00 下午
 */
public class CustomIrule extends AbstractLoadBalancerRule {



    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }

    @Override
    public Server choose(Object key) {
        Server server=new Server("localhost",8082);
        return server;
    }
}
