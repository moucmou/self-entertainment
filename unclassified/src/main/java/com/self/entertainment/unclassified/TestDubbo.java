package com.self.entertainment.unclassified;

import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * @author AmazingZ
 * @date 2019/4/19 17:28
 */
public class TestDubbo {

    public static void main(String[] args) {

        ExtensionLoader<Robot> extensionLoader = ExtensionLoader.getExtensionLoader(Robot.class);
        Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
        optimusPrime.sayHello();
        Robot bumblebee = extensionLoader.getExtension("bumblebee");
        bumblebee.sayHello();
    }
}
