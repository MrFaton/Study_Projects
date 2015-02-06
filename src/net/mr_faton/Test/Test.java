package net.mr_faton.Test;

import java.nio.charset.Charset;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String, Charset> charsetMap = Charset.availableCharsets();
        for (String name : charsetMap.keySet()) {
            System.out.println(name);
        }
    }
}