package cn.example.amazingt.controller;

import cn.example.amazingt.annotation.CurrUser;
import cn.example.amazingt.dto.LoginDto;
import cn.example.amazingt.entity.User;
import cn.example.amazingt.service.IUserService;
import cn.example.amazingt.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author AmazingZ
 * @date 2018/9/15 15:43
 */
@CrossOrigin
@Controller
@RequestMapping(value = "users")
public class UserRestController {

    @Autowired
    private IUserService userService;


    /**
     * 登陆
     *
     * @param loginDto
     * @return
     */
    @RequestMapping(value = {"/v1/login"}, method = {RequestMethod.POST})
    @ResponseBody
    public ResponseData login(@RequestBody LoginDto loginDto, HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession(false);
        return userService.getByLogin(loginDto, session);
    }

    /**
     * 登陆
     *
     * @return
     */
    @RequestMapping(value = {"/login"}, method = {RequestMethod.GET})
    public String loginPage() {
        return "login";
    }

    /**
     * 注销
     *
     * @return
     */
    @RequestMapping(value = {"/v1/logout"}, method = {RequestMethod.GET})
    public String logout(HttpSession httpSession) {
        userService.logout(httpSession);
        return "login";
    }

    /**
     * 注册
     *
     * @param loginDto
     * @return
     */

    @RequestMapping(value = {"/v1/addUser"}, method = {RequestMethod.POST})
    @ResponseBody
    public ResponseData register(@RequestBody LoginDto loginDto) {
        return userService.addByLogin(loginDto);
    }


    /**
     * 注册
     *
     * @return
     */

    @RequestMapping(value = {"/register"}, method = {RequestMethod.GET})
    public String registerPage() {
//        if ("XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest) httpServletRequest).getHeader("X-Requested-With"))) {
//
//        }

        return "register";

    }
}
