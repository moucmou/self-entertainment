package com.self.entertainment.service;

import lombok.extern.slf4j.Slf4j;

public class What {

    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try {
            classLoader.loadClass("com.self.entertainment.service.Test");
            Class.forName("com.self.entertainment.service.Test");
        } catch (ClassNotFoundException ignored) {
        }
        System.out.println();
    }
}
