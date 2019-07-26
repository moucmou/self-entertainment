package cn.example.amazingt.util;


import cn.example.amazingt.aop.CurrUserMethodArgumentResolver;
import cn.example.amazingt.listener.SessionListener;
import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.servlet.Filter;
import java.util.EventListener;
import java.util.List;

/**
 * @author AmazingZ
 * @date 2018/9/15 11:43
 */
@Configuration
public class WebSecurityConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userInterceptor()).addPathPatterns("/web/**").addPathPatterns("")
                .excludePathPatterns("/users/**")
                .excludePathPatterns("/static/**");
        super.addInterceptors(registry);
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/META-INF/resources/")
                .addResourceLocations("classpath:/resources/")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/public/");
        super.addResourceHandlers(registry);
    }

    @Bean
    public UserInterceptor userInterceptor() {
        return new UserInterceptor();
    }


    @Bean
    public ServletListenerRegistrationBean<EventListener> sessionListener() {
        ServletListenerRegistrationBean<EventListener> sessionListener = new ServletListenerRegistrationBean<>();
        sessionListener.setListener(new SessionListener());
        return sessionListener;
    }
//    @Bean
//    public HttpFilter remoteIpFilter() {
//        return new HttpFilter();
//    }
////
//    @Bean
//    public FilterRegistrationBean preFilterRegistration() {
//        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>();
//        registration.setFilter(new HttpFilter());//添加过滤器
//        registration.addUrlPatterns("/*");//设置过滤路径，/*所有路径
//        registration.addInitParameter("name", "alue");//添加默认参数
//        registration.setName("HttpFilter");//设置优先级
//        registration.setOrder(1);//设置优先级
//        return registration;
//    }

    /**
     * 实例化自己的注解解析器
     *
     * @return
     */
    @Bean
    public CurrUserMethodArgumentResolver currUserMethodArgumentResolver() {
        return new CurrUserMethodArgumentResolver();
    }

    /**
     * 其实从这里看出来，与配置在spring-servlet.xml中相比，都是实例化一个自己注解解析器，
     * 然后将它add进spring的List<HandlerMethodArgumentResolver> argumentResolvers中
     * 最后交给spring统一管理
     *
     * @param argumentResolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(currUserMethodArgumentResolver());
        super.addArgumentResolvers(argumentResolvers);
    }

}
