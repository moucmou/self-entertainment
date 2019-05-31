package com.self.entertainment.rediscache;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RedisCacheApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void contextLoads() {
        stringRedisTemplate.opsForHash().put("data", "name", "zt");
        log.info(Objects.requireNonNull(stringRedisTemplate.opsForHash().get("data", "name")).toString());
    }

}
