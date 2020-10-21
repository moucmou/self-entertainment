package com.feign.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "test")
public interface TestServiceClient extends TestService{

}
