package com.feign;

import com.feign.client.TestServiceClient;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.feign.client"})
@EnableFeignClients
public class OpenFeignApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(OpenFeignApplication.class, args);
    }

    @Resource
    TestServiceClient testServiceClient;

    @Override
    public void run(String... args) throws Exception {
        testServiceClient.queryByDictValCode("123");
        System.out.println();
    }
}
