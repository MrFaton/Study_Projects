package net.mr_faton.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Map<String, Long> map = new ConcurrentHashMap<>();
        map.put("1", 10L);
        map.put("2", 20L);
        map.put("3", 30L);
        map.put("4", 40L);
        System.out.println(map.values());
        map.remove("3");
        System.out.println(map.values());
    }
}