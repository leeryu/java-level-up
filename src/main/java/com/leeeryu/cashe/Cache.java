package com.leeeryu.cashe;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {
    private HashMap<String, Object> cacheMap;
    private static Cache instance;

    private Cache() {
        cacheMap = new HashMap<>();
    }

    public static Cache getInstance() {
        if (instance == null)
            instance = new Cache();

        return instance;
    }

    public void put(String key, Object value) {
        cacheMap.put(key, value);
    }

    public Object get(String key) {
        return cacheMap.get(key);
    }

    public boolean contains(String key) {
        return cacheMap.containsKey(key);
    }

    public void clear() {
        cacheMap.clear();
    }

    @Override
    public String toString() {
        return "Cache{" +
                "cacheMap=" + cacheMap +
                '}';
    }

    public static void main(String[] args) {
        Cache cache = Cache.getInstance();
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    cache.put("MC000" + j, j);
                }
            });
        }

        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
//        Cache{cacheMap={MC0005=5, MC0004=4, MC0003=3, MC0002=2, MC0009=9, MC0008=8, MC0007=7, MC0006=6, MC0001=1, MC0000=0}}
        System.out.println(cache.toString());
    }
}
