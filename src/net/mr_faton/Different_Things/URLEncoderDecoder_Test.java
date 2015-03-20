package net.mr_faton.Different_Things;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by root on 20.03.2015.
 */
public class URLEncoderDecoder_Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "привет";
        String result = URLEncoder.encode(str, "UTF-8");
        System.out.println("привет = " + result);

//        String URLStr = "%F3%E1%F5%F2*%EB%E9%E8%E1";
        String URLStr = "%FA%CE%C1%CA%D4%C9";
        String resultURL = URLDecoder.decode(URLStr, "koi8-u");
        System.out.println("URLStr = " + resultURL);
    }
}
