package com.self.entertainment.unclassified;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * @author AmazingZ
 * @date 2019/4/19 11:33
 */
@Component
public class TestG implements ApplicationListener<ContextRefreshedEvent>  {

    @Autowired
    private TestI testI;
    @Autowired
    private ApplicationContext applicationContext;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        testI.sayHello("");
//       for(String beanDefinitionName:((AnnotationConfigApplicationContext) applicationContext).getBeanFactory().getBeanDefinitionNames()){
//           System.out.println(beanDefinitionName);
//       }

        try {
            String x=new String("123".getBytes(), "Unicode");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
