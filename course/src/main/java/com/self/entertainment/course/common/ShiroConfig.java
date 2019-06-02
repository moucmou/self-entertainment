package com.self.entertainment.course.common;

import com.self.entertainment.course.config.AdminFilter;
import com.self.entertainment.course.config.CustomFilter;
import com.self.entertainment.course.config.UserFilter;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chain = new DefaultShiroFilterChainDefinition();
        chain.addPathDefinition("/user/**", "userFilter");
        chain.addPathDefinition("/admin/**", "adminFilter");
        chain.addPathDefinition("/**", "anon");
        return chain;
    }

    @Bean
    ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager,
                                                  UserFilter userFilter,
                                                  AdminFilter adminFilter,
                                                  ShiroFilterChainDefinition shiroFilterChainDefinition) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.getFilters().put("userFilter", userFilter);
        shiroFilterFactoryBean.getFilters().put("adminFilter", adminFilter);
        shiroFilterFactoryBean.setFilterChainDefinitionMap(shiroFilterChainDefinition.getFilterChainMap());
        return shiroFilterFactoryBean;

    }

}
