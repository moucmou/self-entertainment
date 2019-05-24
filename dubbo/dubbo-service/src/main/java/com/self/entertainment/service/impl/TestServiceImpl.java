package com.self.entertainment.service.impl;

import entertainment.service.TestService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author AmazingZ
 * @date 2019/5/21 13:45
 */
@Service
public class TestServiceImpl implements TestService {

    @Override
    public String sayWorld() {
        return "little brother";
    }
}
