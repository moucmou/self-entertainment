package com.self.entertainment.course.controller;

import com.self.entertainment.course.dao.TestRepository;
import com.self.entertainment.course.dao.entity.Test;
import com.self.entertainment.course.service.TestService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author AmazingZ
 * @date 2019/7/3 9:56
 */
@RestController
public class TestHibernateController {

    @Autowired
    TestService testService;

    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    public String sayHello() {
        testService.save();
        return "Hello";
    }
}
