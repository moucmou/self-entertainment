package cn.example.amazingt.annotation;

import java.lang.annotation.*;

/**
 * @author AmazingZ
 * @date 2018/9/15 17:43
 */

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrUser {

}
