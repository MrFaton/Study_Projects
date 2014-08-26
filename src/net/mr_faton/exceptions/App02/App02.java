package net.mr_faton.exceptions.App02;

import java.io.IOException;

/**
 * Created by root on 26.08.2014.
 */
public class App02 {
    public static void main(String[] args) throws IOException {
        try {
            int area = area(-40, 22);
            System.out.println(area);
        } catch (IllegalArgumentException e) {
            System.out.println("seems like bad argument");
        }
        System.out.println("next runing code");
    }

    public static int area(int a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("a<0 || b<0, a=" + a + " b=" + b);
        }
        return a * b;
    }
}
//С блоком try-catch мы натыкаемся на ошибку, отлавливаем её, делаем соответствующие действия и продолжаем работать