package com.self.entertainment.simple;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ServletMappingConfig {
    public static List<ServletMapping> servletMappingList = new CopyOnWriteArrayList<>(
            Collections.singletonList(ServletMapping.of("helloWorld", "/helloWorld", "com.self.entertainment.simple.SimpleServlet")));

}
