package com.self.entertainment.mybatis.sharding;

import io.shardingsphere.core.keygen.KeyGenerator;

/**
 * @author AmazingZ
 * @date 2019/7/25 19:19
 */
public class TestKeyGenerator implements KeyGenerator {


    public TestKeyGenerator() {
    }

    @Override
    public Number generateKey() {
        return 6666;
    }
}
