package com.self.entertainment.consulprovider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author AmazingZ
 * @date 2019/9/17 20:26
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {
    @RequestMapping(value = "/echo",method = RequestMethod.GET)
    public String testFirstConsul(String x){
        return x;
    }

    @RequestMapping(value = "/echo1",method = RequestMethod.PUT)
    public String testFirstConsul1(String x){
        return x;
    }
}
