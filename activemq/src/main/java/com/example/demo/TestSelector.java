package com.example.demo;

import com.sun.deploy.util.ArrayUtil;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author AmazingZ
 * @date 2019/7/1 15:32
 */
public class TestSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {


        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(ComponentScan.class.getName());
        String[] basePackages = (String[]) annotationAttributes.get("basePackages");
        if (basePackages == null || basePackages.length == 0) {
            basePackages = new String[]{"com.example.demo"};
        }
//        if (basePackages == null || basePackages.length == 0) {//HelloServiceScan的basePackages默认为空数组
//            String basePackage = null;
//            try {
//                basePackage = Class.forName(importingClassMetadata.getClassName()).getPackage().getName();
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//            basePackages = new String[] {basePackage};
//        }
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
        TypeFilter helloServiceFilter = new AssignableTypeFilter(TestInterFace.class);
        scanner.addIncludeFilter(helloServiceFilter);
        Set<String> classes = new HashSet<>();
        for (String basePackage : basePackages) {
            scanner.findCandidateComponents(basePackage).forEach(beanDefinition -> classes.add(beanDefinition.getBeanClassName()));
        }
        return classes.toArray(new String[0]);


//        importingClassMetadata.getAnnotationTypes().forEach(System.out::println);
//        System.out.println("我在这个selector里面");
//        return new String[]{"com.example.demo.TestConfig"};
    }
}
