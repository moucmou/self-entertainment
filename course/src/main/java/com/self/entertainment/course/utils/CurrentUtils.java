package com.self.entertainment.course.utils;

import com.self.entertainment.course.dao.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class CurrentUtils {

    private CurrentUtils(){};

    public static User getCurrent(){
        Subject subject = SecurityUtils.getSubject();
        return (User) subject.getPrincipal();
    }
}
