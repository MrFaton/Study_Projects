package net.mr_faton.IO;

import java.util.Arrays;

/**
 * Created by Faton on 16.09.2014.
 */
public class App01 {
    public static void main(String[] args) {
        testCodePoint(65);//Номер символа в таблице Unicode или его codepoint
        testCodePoint(9819);
        testCodePoint(476);
        testCodePoint(10_000);//можно ставить в цифрах подчёркивание
        testCodePoint(50_000);
        testCodePoint(165_000); // один символ, с длиной строки 2, так как кодируется в 2 чара, но по одному эти чары не имеют смысла при выводе, и тут 1 кодепоинт
        testCodePoint(9_773);
        testCodePoint(9_822);

    }

    private static void testCodePoint(int codePoint) {
        char[] charArray = Character.toChars(codePoint);//Символ может быть представлен только как массив чаров, который равен классу-обёртке (Character). Потому что иногда для представления одного символа необходимо несколько чаров
        System.out.println("char[]: " + Arrays.toString(charArray));
        String str = new String(charArray);
        System.out.println("String: " + str);
        System.out.println("String.length: " + str.length()); //метод длина строки иногда врёт, как, например для кодепоинта (символа) с номером 165000, для его отображение нужно 2 чара, поэтому есть метод codePointCount, который показывает длину символов
        System.out.println("String.codePointCount: " + str.codePointCount(0, str.length()));
        System.out.println("\u20AC");
    }
}
