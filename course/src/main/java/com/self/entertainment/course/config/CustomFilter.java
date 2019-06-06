package com.self.entertainment.course.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.self.entertainment.course.common.ResponseData;
import com.self.entertainment.course.dao.entity.User;
import com.self.entertainment.course.utils.ShiroFilterUtils;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.Objects;

public abstract class CustomFilter extends AuthenticatingFilter {

    @Autowired
    ObjectMapper objectMapper;

    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) throws Exception {
        String userNam = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        return new UsernamePasswordToken(userNam, passWord);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        ResponseData<String> responseData = ResponseData.fail("未登陆或无权限");
//        if (ShiroFilterUtils.isAjax(request)) {// ajax请求
//            IOUtils.write(objectMapper.writeValueAsBytes(responseData),response.getOutputStream());
//        }
        IOUtils.write(objectMapper.writeValueAsBytes(responseData), response.getOutputStream());
        return false;
    }
    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {

        boolean isPermitted = true;
        Subject subject = getSubject(request, response);
        if (Objects.isNull(subject.getPrincipal())) isPermitted = false;
        User user = (User) subject.getPrincipal();
        if (Objects.isNull(user) || !hasPermitted(user.getRole()))
            isPermitted = false;

        return isPermitted;
    }

    public abstract boolean hasPermitted(Integer role);
}
