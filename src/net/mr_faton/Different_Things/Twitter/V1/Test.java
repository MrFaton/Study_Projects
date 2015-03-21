package net.mr_faton.Different_Things.Twitter.V1;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

        Map<String, List<String>> requestProperties = con.getRequestProperties();
        System.out.println("requests:");
        for (Map.Entry<String, List<String>> key : requestProperties.entrySet()) {
            System.out.println("key = " + key.getKey());
            System.out.println("values = " + key.getValue());
            for (String value : key.getValue()) {
                System.out.println(value);
            }
            System.out.println("+++++++++++++++++");
        }


        int responseCode = con.getResponseCode();
        System.out.println("respCod = " + responseCode);

        Map<String, List<String>> headerFields = con.getHeaderFields();
        System.out.println("Response fields:");

        for (Map.Entry<String, List<String>> key : headerFields.entrySet()) {
            System.out.println(key.getKey() + " = " + key.getValue());
        }
        System.out.println("++++++++++++++++++++++++");

        System.out.println("Received Page:");
        InputStream in = con.getInputStream();

        byte[] buf = new byte[1512000];

        int count = in.read(buf);
        String page = new String(buf, 0, count, "UTF-8");
        System.out.println(page);
        in.close();
        con.disconnect();

    }
}
