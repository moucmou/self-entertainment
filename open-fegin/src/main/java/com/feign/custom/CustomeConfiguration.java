package com.feign.custom;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;

/**
 * @author: zhutao
 * @date: 2020/10/20 6:00 下午
 */
public class CustomeConfiguration {

    @Bean
    IRule rule(){
        return new CustomIrule();
    }
}
