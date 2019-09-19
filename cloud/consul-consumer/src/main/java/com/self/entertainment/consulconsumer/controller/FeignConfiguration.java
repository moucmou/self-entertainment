package com.self.entertainment.consulconsumer.controller;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import feign.Contract;
import feign.jaxrs.JAXRSContract;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author AmazingZ
 * @date 2019/9/17 21:50
 */
@Configuration
public class FeignConfiguration {

    @Bean
    Contract JAXRSContract(){
        return new JAXRSContract();
    }

//    @Bean
//    public ServletRegistrationBean getServlet(){
//
//        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
//        ServletRegistrationBean registrationBean = new ServletRegistrationBean<>(streamServlet,"/actuator/hystrix.stream");
//        registrationBean.setLoadOnStartup(1);
////        registrationBean.setName("HystrixMetricsStreamServlet");
//        return registrationBean;
//    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
