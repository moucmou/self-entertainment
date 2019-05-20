package com.self.entertainment.unclassified;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author AmazingZ
 * @date 2019/5/5 17:07
 */
@RestController
public class TestController {

    @RequestMapping("/didi")
    public String sayHello(){
        return "hello world";
    }
}
