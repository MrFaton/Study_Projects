package net.mr_faton.Test;


import java.io.*;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String text = "<a href=/quality.html>Качество</a></li>\n" +
                "а теперь просто строка" +
                "<div id=\"guestbook_link\"><a href='http://expogas.net/guestbook.html'>Гостевая книга</a></div>";

        String regExp = "a\\s?href\\s?=\\s?.+>";
        Pattern pattern = Pattern.compile(regExp, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String match = text.substring(start, end);

            System.out.println(match);
        }
    }
}