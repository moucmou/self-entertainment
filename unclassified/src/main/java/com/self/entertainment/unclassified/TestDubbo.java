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

//        String x =	"local lockClientId = redis.call('GET', KEYS[1])\n" +
//                "if lockClientId == ARGV[1] then\n" +
//                "  redis.call('PEXPIRE', KEYS[1], ARGV[2])\n" +
//                "  return true\n" +
//                "elseif not lockClientId then\n" +
//                "  redis.call('SET', KEYS[1], ARGV[1], 'PX', ARGV[2])\n" +
//                "  return true\n" +
//                "end\n" +
//                "return false";
    }
}
