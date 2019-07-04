package com.self.entertainment.common;

import java.lang.annotation.*;

/**
 * @author AmazingZ
 * @date 2019/7/4 11:27
 */

/**
 * 修改消费者注册的地址，即不要加类名方法名啥的，走rest、其他语言又不需要本地反射执行，拼接口就好了
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServerType {

    String value();

}
