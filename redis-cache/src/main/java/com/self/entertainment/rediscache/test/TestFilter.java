package com.self.entertainment.rediscache.test;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author AmazingZ
 * @date 2019/7/2 18:00
 */
@WebFilter(urlPatterns = "/*")
@Component
public class TestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("我是通过注解方式添加的filter");
        chain.doFilter(request, response);
    }
}
