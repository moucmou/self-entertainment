package com.self.entertainment.mybatis.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AmazingZ
 * @date 2019/8/5 15:45
 */

@Component
@Slf4j
public class TestMvcConfig implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof WebMvcConfigurationSupport) {
//                Method method = bean.getClass().getDeclaredMethod("addArgumentResolvers", List.class);
//                method.setAccessible(true);
            HandlerMethodArgumentResolver handlerMethodArgumentResolver = new HandlerMethodArgumentResolver() {
                @Override
                public boolean supportsParameter(MethodParameter parameter) {
                    return true;
                }

                @Override
                public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
                    return null;
                }
            };
            List<HandlerMethodArgumentResolver> handlerMethodArgumentResolvers = new ArrayList<>();
            handlerMethodArgumentResolvers.add(handlerMethodArgumentResolver);
//                method.invoke(bean, handlerMethodArgumentResolvers);
//            ((WebMvcConfigurationSupport)bean).addArgumentResolvers();
            log.info("");
            System.out.println();
        }
        return bean;
    }

    ;

}
