package net.mr_faton.Test;

import java.io.IOException;
import java.net.URLEncoder;

public class Test {
    private static String telegramSub = "       Знайти        ";
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println(URLEncoder.encode(telegramSub, "koi8-u"));
    }
}

