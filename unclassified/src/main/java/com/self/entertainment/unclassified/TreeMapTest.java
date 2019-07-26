package com.self.entertainment.unclassified;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author AmazingZ
 * @date 2019/7/11 9:30
 */
public class TreeMapTest {

    public static void main(String[] args) {

        TreeMap<String, String> treeMap = new TreeMap<>(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });
        treeMap.put("123", "123");
    }
}
