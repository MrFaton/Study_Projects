package net.mr_faton.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Base64;

public class Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "САУР*КИХА";
        String encodedStr = URLEncoder.encode(str, "koi8-u");
        System.out.println(encodedStr);
        System.out.println(encodedStr.length());
    }
}