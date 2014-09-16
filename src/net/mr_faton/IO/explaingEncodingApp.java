package net.mr_faton.IO;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * Created by root on 16.09.2014.
 */
public class explaingEncodingApp {
    public static void main(String[] args) throws Exception {
        String str0="Hello";
        String str1="Привет";
        String str2="Меня зовут Игорь :-)";
        String str3="Hello this is test App";

        showNumberInUnicode(str0);
        showNumberInUnicode(str1);
        showNumberInUnicode(str2);
        showNumberInUnicode(str3);

        System.out.println("**********************");

        codinEncodingUTF8(str0);
        codinEncodingUTF8(str1);
        codinEncodingUTF8(str2);
        codinEncodingUTF8(str3);

        System.out.println("**********************");

        codingEncodingWindows1251(str0);
        codingEncodingWindows1251(str1);
        codingEncodingWindows1251(str2);
        codingEncodingWindows1251(str3);

        System.out.println("**********************");

        codingEncodingUnicode(str0);
        codingEncodingUnicode(str1);
        codingEncodingUnicode(str2);
        codingEncodingUnicode(str3);
    }
    private static void showNumberInUnicode(String sentence){
        for (int i = 0; i<sentence.length(); i++){
            System.out.println(sentence.charAt(i)+"="+(int)sentence.charAt(i)+" codepoint (позиция) in Unicode"); //Позиция символа в Юникоде
        }
        System.out.println();
    }

    private static void codinEncodingUTF8(String line) throws UnsupportedEncodingException {
        System.out.println("Слово в байтах, использоя правило (кодировку) UTF-8:");
        byte[] bytes=line.getBytes("UTF-8");
        System.out.println(line+" = "+ Arrays.toString(bytes)); //Разложили каждый символ слова, его порядковый номер в Юникоде (codepoint) в байтовый массив (codeunit), преобразованный по правилу UTF-8(при помощи кодировки UTF-8)
        System.out.println("Колличество байтов в массиве: "+bytes.length); //Просто посчитали колличество байтов в массиве, необходимое для содержания преобразованной строки
        String item=new String(bytes, "UTF-8"); //Строим новую строку при помощи правила UTF-8(при помощи кодировки UTF-8) из массива байтов. Тут можно было не указывать UTF-8, в Java эта кодировка стоит по умолчанию
        System.out.println("Преобразовання строка из массива байтов по правилу (кодировке) UTF-8: "+item);
        String wrongItem=new String(bytes, "windows-1251");
        System.out.println("При помощи другой кодировки (windows-1251): "+wrongItem); //В байтовый массив строка была закодирована при помощь кодировки UTF-8, а построить строку из массива байтов мы пытаемся при помощь кодировки windows-1251(cp-1251), это приводит к абракадабре в рус. буквах
        System.out.println();
    }

    private static void codingEncodingWindows1251(String line) throws UnsupportedEncodingException {
        System.out.println();
        System.out.println("Слово в байтах, использоя правило (кодировку) windows-1251:");
        byte[] bytes=line.getBytes("windows-1251");
        System.out.println(line+" = "+Arrays.toString(bytes));
        System.out.println("Колличество байтов в массиве: "+bytes.length);
        String item=new String(bytes, "windows-1251");
        System.out.println("Преобразовання строка из массива байтов по правилу (кодировке) windows-1251: "+item);
        String wrongItem=new String(bytes, "UTF-8");
        System.out.println("При помощи другой кодировки (UTF-8): "+wrongItem);
    }

    private static void codingEncodingUnicode(String line) throws UnsupportedEncodingException {
        System.out.println();
        System.out.println("Слово в байтах, использоя правило (кодировку) Unicode:");
        byte[] bytes=line.getBytes("Unicode");
        System.out.println(line+" = "+Arrays.toString(bytes));
        System.out.println("Колличество байтов в массиве: "+bytes.length);
        String item=new String(bytes, "Unicode");
        System.out.println("Преобразовання строка из массива байтов по правилу (кодировке) Unicode: "+item);
        String wrongItem=new String(bytes, "UTF-8");
        System.out.println("При помощи другой кодировки (UTF-8): "+wrongItem);
    }
}

//Есть всего одно основная кодировка - Unicode. Все остальные (UTF-8, windows-1251 и т.д.) просто преобразовывают ей, экономя место в байтах
//Одно только слово "Привет" в "Unicode" заняло 14 байтов, в UTF-8 заняло 12 байтов, а в windows-1251 всего 6 байтов.
//Поэтому иногда удобней кодировки с переменной длиной(UTF-8, windows-1251), чем с фиксированной длиной (Unicode).
