package net.mr_faton.exceptions.App01;

import java.io.IOException;

/**
 * Created by root on 26.08.2014.
 */
public class App01 {
    public static void main(String[] args) throws IOException {
        int area = area(-10, 20);
        System.out.println(area);
    }

    public static int area(int a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("a<0 || b<0, a=" + a + " b=" + b);
        }
        return a * b;
    }
}

// Без блока try-catch, мы просто схватываем эксепшн и вылетаем, при этом выводя сообщение ошибки