package com.self.entertainment.jetty.client;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/resteasy")
public class TestController {

    @RequestMapping(value = "/echo",method = {RequestMethod.POST})
    public String sayHello(@RequestBody String repeat){
        return repeat;
    }
}
