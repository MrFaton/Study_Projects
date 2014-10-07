package net.mr_faton.Collections.Map;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Faton on 03.10.2014.
 */
public class App00 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println("***********");

        map.put("Килька", 25);
        System.out.println("1: " + map.put("Сардины", 3));//возвращает то, что было раньше по этому ключу
        System.out.println("2: " + map.put("Килька", 3));
        System.out.println("3: " + map.get("Килька"));
        System.out.println("4: " + map.get("Сёмга"));
        System.out.println("5: " + map.size());
        System.out.println("6: " + map.isEmpty());
        System.out.println("7: " + map);

        System.out.println("8: " + map.remove("xxx"));
        System.out.println("9: " + map.remove("Килька"));//возвращает старое значение
        System.out.println("10: " + map);

        System.out.println("11: " + map.keySet());
        System.out.println("12: " + map.values());
        System.out.println("13: " + map.entrySet());
    }
}
