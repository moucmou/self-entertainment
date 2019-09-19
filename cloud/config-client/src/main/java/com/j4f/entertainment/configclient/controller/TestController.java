package com.j4f.entertainment.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author AmazingZ
 * @date 2019/9/18 14:54
 */
@RestController
public class TestController {

    @Value("${name}")
    private String name;
    @RequestMapping(value="test")
    public String getConfig(){
        return name;
    }
}
