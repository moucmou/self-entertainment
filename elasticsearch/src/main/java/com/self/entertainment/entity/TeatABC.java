package com.self.entertainment.entity;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * @author AmazingZ
 * @date 2019/8/30 10:43
 */
public class TeatABC {
    static volatile boolean flag = false;

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);

        Object object = new Object();
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                for (; ; ) {
                    if (atomicInteger.get() % 2 == 0) {
                        break;
                    }
                }
                System.out.println("线程A打印了：" + atomicInteger.get());
                atomicInteger.incrementAndGet();

            }

        }).start();
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                for (; ; ) {
                    if (atomicInteger.get() % 2 == 1) {
                        break;
                    }
                }
                System.out.println("线程B打印了：" + atomicInteger.get());
                atomicInteger.incrementAndGet();
            }
        }).start();
//        LockSupport.park(new Object());
    }
}
