package com.self.entertainment.dubboservice.service.impl;

import com.self.entertainment.dubboservice.service.TestService;
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
