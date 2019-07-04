package com.self.entertainment.common;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author AmazingZ
 * @date 2019/7/4 11:53
 */
@Documented
@Retention(RUNTIME)
@Target(TYPE)
public @interface Interceptor {

     Class<?>[] interceptorClass() default {};
}
