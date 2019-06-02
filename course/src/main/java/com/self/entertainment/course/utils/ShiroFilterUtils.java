package com.self.entertainment.course.utils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class ShiroFilterUtils {

    final static Class<? extends ShiroFilterUtils> CLAZZ = ShiroFilterUtils.class;
    /**
     * 是否是Ajax请求
     * @param request
     * @return
     */
    public static boolean isAjax(ServletRequest request){
        return "XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest) request).getHeader("X-Requested-With"));
    }

    public static void out(ServletResponse response, Map<String, String> resultMap){


    }
}
