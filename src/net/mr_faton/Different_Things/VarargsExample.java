package net.mr_faton.Different_Things;

import java.util.Arrays;

/**
 * Created by Faton on 07.10.2014.
 */
public class VarargsExample {
    public static void main(String[] args) {
        f(new int[]{3, 8, 9, 12});
        System.out.println("Метод f2 с вараргами:");

        f2(2, 7);
        f2(6, 8, 94, 55);
        System.out.println("Метод f2 закончился");

        f3("Hello", 1, 3, 4, 77, 44, 34);
    }

    public static void f(int[] args) {
        System.out.println(args[0]);
        System.out.println(Arrays.toString(args));
    }

    public static void f2(int... args) {
        System.out.println(args[0]);
        System.out.println(args[1]);
        System.out.println(Arrays.toString(args));
    }

    public static void f3(String str, int... args) {
        System.out.println(str);
        System.out.println(Arrays.toString(args));
    }
}
//Троеточие в методе f2 - это варарг, который говорит компилятору: слепи мне находу массив из входящих значений и поэтому
//в метде f2 args - это обычный массив. Варарг должен стоять только пследним! Пример, метод f3.