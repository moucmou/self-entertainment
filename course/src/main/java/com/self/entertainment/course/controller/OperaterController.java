package com.self.entertainment.course.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.self.entertainment.course.common.ResponseData;
import com.self.entertainment.course.common.UsernamePasswordTokenEx;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SubjectDAO;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author AmazingZ
 * @date 2019/6/1 16:45
 */
@RestController
@RequestMapping(value = "/")
@Slf4j
public class OperaterController {

    @Autowired
    SubjectDAO subjectDAO;

    @RequestMapping(value = "/anon/login", method = RequestMethod.POST)
    public ResponseData<String> login(String userName, String passWord, Integer role, HttpServletResponse response) {

        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(new UsernamePasswordTokenEx(userName, passWord, role));
        } catch (Exception e) {

            return ResponseData.fail("登陆失败");
        }
        return ResponseData.success("");

    }

    @RequestMapping(value = "/anon/logout", method = RequestMethod.GET)
    public ResponseData<String> loutOut() {
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.isAuthenticated())
            currentUser.logout();
        return ResponseData.success("");
    }

}
