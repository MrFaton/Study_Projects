package net.mr_faton.Different_Things;

/**
 * Created by Faton on 08.11.2014.
 */
public class Notation_2_8_16 {
    public static void main(String[] args) {
        //Перевод десятичного числа в двоичную, восьмеричную и шестнадцатиричную систему счисления
        int x = 189;
        System.out.println(x + " = " + Integer.toString(x, 2) + " в двоичной системе");
        System.out.println(x + " = " + Integer.toString(x, 8) + " в восьмеричной системе");
        System.out.println(x + " = " + Integer.toString(x, 16) + " в шестнадцатиричной системе");

        //запись числе в разных системах

        //двоичная система (так можно записывать с Java 7, а раньше было так Integer.parseInt("110111", 2);)
        int y = 0b110111;
        System.out.println(y);
        //восьмеричная система
        y = 0754;
        System.out.println(y);
        //шестнадцатеричная система
        y = 0xbc7;
        System.out.println(y);
    }
}