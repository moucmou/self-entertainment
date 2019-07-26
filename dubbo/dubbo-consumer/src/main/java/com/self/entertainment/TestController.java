package com.self.entertainment;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        try {
            Thread.sleep(3*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我执行完了");
        return "12312";
    }
}
