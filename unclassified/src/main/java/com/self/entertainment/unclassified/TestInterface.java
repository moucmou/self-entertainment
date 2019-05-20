package com.self.entertainment.unclassified;

import java.io.IOException;

/**
 * @author AmazingZ
 * @date 2019/5/5 17:11
 */
public interface TestInterface {
    default void sayHello(){
        System.out.println(" hello world");
    } ;
}
