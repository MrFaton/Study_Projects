package net.mr_faton.Different_Things.Twitter.V1;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * Created by Mr_Faton on 21.03.2015.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        String url_https = "https://twitter.com/";
        URL url = new URL(url_https);
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:36.0) Gecko/20100101 Firefox/36.0");
        con.setRequestProperty("Accept-Language", "ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3");

        int responseCode = con.getResponseCode();
        System.out.println("respCod = " + responseCode);


        Map<String, List<String>> requestProperties = con.getRequestProperties();
//        System.out.println("requests:");
//        for (Map.Entry<String, List<String>> key : requestProperties.entrySet()) {
//            System.out.println("key = " + key.getKey());
//            System.out.println("values = " + key.getValue());
//            for (String value : key.getValue()) {
//                System.out.println(value);
//            }
//            System.out.println("+++++++++++++++++");
//        }

    }
}
