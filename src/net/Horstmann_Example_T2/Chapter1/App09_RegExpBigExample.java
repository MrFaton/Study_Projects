package net.Horstmann_Example_T2.Chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by root on 08.02.2015.
 */
public class App09_RegExpBigExample {
    public static void main(String[] args) {
        System.out.println("Введи сайт, например (http://expogas.net/), длина сайта не меньше 10 символов:");
        String site;
        Scanner scanner = new Scanner(System.in);
        site = scanner.nextLine();
        if (site.length() < 10) {
            System.out.println("Короткая длина сайта, сайт будет задан по дефолту (http://expogas.net/)");
            site = "http://expogas.net/";
        }

        StringBuilder text = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new URL(site).openStream(), "UTF-8"))) {
            int ch;
            while ((ch = in.read()) != -1) {
                text.append((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String regexp = "(.*a href\\s*=\\s*)(.*?)>";
        Pattern pattern = Pattern.compile(regexp, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String match = text.substring(start, end);
            System.out.println(match);

            System.out.println(matcher.group(2) + "+++++++++++++++");
        }
    }
}
