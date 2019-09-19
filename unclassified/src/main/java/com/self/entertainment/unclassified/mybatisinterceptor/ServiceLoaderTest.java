package com.self.entertainment.unclassified.mybatisinterceptor;

import com.self.entertainment.unclassified.Robot;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author AmazingZ
 * @date 2019/8/28 9:32
 */
public class ServiceLoaderTest {

    public static void main(String[] args) {
        ServiceLoader<Robot> serviceLoader=ServiceLoader.load(Robot.class);
        Iterator<Robot> iterator= serviceLoader.iterator();
        System.out.println();
    }
}
