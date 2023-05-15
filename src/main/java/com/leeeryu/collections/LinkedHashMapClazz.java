package com.leeeryu.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapClazz {
    public static void main(String[] args) {
        final LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();

        linkedHashMap.put("3", "3");
        linkedHashMap.put("1", "3");

        System.out.println(linkedHashMap);

        final Map<String, String> map = new HashMap<>();
        map.put("3", "3");
        map.put("1", "1");
        map.put("4", "4");
        map.put("2", "7");

        System.out.println(map);
    }
}
