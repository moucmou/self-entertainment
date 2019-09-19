package com.self.entertainment.consulconsumer.service.impl;

import com.self.entertainment.consulconsumer.service.TestService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author AmazingZ
 * @date 2019/9/17 20:35
 */
@FeignClient(value="consul-provider")
public interface TestServiceImpl extends TestService {
}
