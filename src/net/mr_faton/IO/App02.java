package net.mr_faton.IO;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * Created by Faton on 16.09.2014.
 */
public class App02 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "♛";
        System.out.println(str.charAt(0));
        System.out.println((int) str.charAt(0));//номер символа в таблице Unicode
        System.out.println(Arrays.toString(str.getBytes("UTF-8")));//символ "♛", у которо в таблице Юникода номер 9819, кодируется тремя байтами.
        System.out.println(Arrays.toString(str.getBytes("UTF-16BE")));
        System.out.println(Arrays.toString(str.getBytes("UTF-32")));
        System.out.println(Arrays.toString(str.getBytes("KOI8")));//KOI8 проблемная, при закодировании занимает 1 байт, а вот раскодировать не может то, что закодировала
        System.out.println(new String(str.getBytes("KOI8"), "KOI8"));//не может раскодировать то, что зкодировала
    }
}
