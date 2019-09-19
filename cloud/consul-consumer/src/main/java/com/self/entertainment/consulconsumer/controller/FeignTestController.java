package com.self.entertainment.consulconsumer.controller;

import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import com.self.entertainment.consulconsumer.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @author AmazingZ
 * @date 2019/9/17 20:52
 */
@RestController
public class FeignTestController {

    @Autowired
    TestService testService;
    /**
     * 监控页面
     * @see HystrixCommandProperties
     *  @see  HystrixPropertiesManager
     *  参数里面的属性可以到这里面去看
     *  https://blog.csdn.net/u012314558/article/details/78347219   //这篇博客详细讲了每一个参数
     * @param x
     * @return
     */
    @RequestMapping(value = "test", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "toFail",commandProperties = {
//            execution.isolation.thread.interruptOnTimeout
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value ="5000" )
    })
    public String test(String x) {

        return testService.echo(x);
    }

    public String toFail(String x) {
        return "调用失败了....";
    }


}
