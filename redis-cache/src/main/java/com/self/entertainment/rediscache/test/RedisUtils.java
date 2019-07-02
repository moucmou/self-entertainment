package com.self.entertainment.rediscache.test;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author AmazingZ
 * @date 2019/7/2 10:56
 */
@Component
public class RedisUtils implements InitializingBean {

    @Autowired
    RedisTemplate redisTemplate;


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println();
    }
}
