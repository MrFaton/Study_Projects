package net.mr_faton.Different_Things;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * Created by Faton on 16.09.2014.
 */
public class PublicTest {
    public static void main(String[] args) throws Exception {
        String str0="Hello";
        String str1="Привет";

        showNumberInUnicode(str0);
        showNumberInUnicode(str1);

        codinSize(str0);
        codinSize(str1);
    }
    private static void showNumberInUnicode(String sentence){
        for (int i = 0; i<sentence.length(); i++){
            System.out.println(sentence.charAt(i)+"="+(int)sentence.charAt(i)+" in Unicode");
        }
        System.out.println();
    }

    private static void codinSize(String line) throws UnsupportedEncodingException {
        System.out.println("Слово в байтах, использоя правило UTF-8");
        System.out.println(line+" = "+Arrays.toString(line.getBytes("UTF-8")));
        System.out.println(line.getBytes("UTF-8").length);
        System.out.println();
    }
}
