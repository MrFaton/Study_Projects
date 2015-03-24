package net.mr_faton.Different_Things.Twitter.V1;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * Created by Mr_Faton on 21.03.2015.
 */
public class Test222 {
    public static void main(String[] args) throws IOException {
        String url_https = "https://twitter.com/";
        URL url = new URL(url_https);
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:36.0) Gecko/20100101 Firefox/36.0");
        con.setRequestProperty("Accept-Language", "ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3");
        con.setRequestProperty("Cookie", "guest_id=v1%3A139109814235500915; __utma=43838368.2078267608.1394892346.1398320924.1399178177.8; remember_checked_on=1; eu_cn=1; _ga=GA1.2.2078267608.1394892346; twll=l%3D1403867540; remember_checked=0; u=db738e424c81b03b78a7821b90b0c8ed; device_token=\"7cfpVkfI8Uf4y2m0NWpSl6UwQpZX51gXn8sBOCXgnXPqQt6iL1k9izpk+/adl4MQY5CIHz9Zlco4xzhgRhCDV9Fmo6v5IjqocuCa62y7ZePzlGiDMaZgBtBY+tWOZH6HPNP6eyyUKoTM6t5tpNVDPxl1vcfAr9i0enwsmLHqsB0mPuR1qBXyBw==\"; auth_token=8f9f0f039ae3647504ed9cbee138a17bc034133d");

        int responseCode = con.getResponseCode();
        System.out.println("respCod = " + responseCode);

        Map<String, List<String>> headerFields = con.getHeaderFields();
        System.out.println("Response fields:");

        for (Map.Entry<String, List<String>> key : headerFields.entrySet()) {
            System.out.println(key.getKey() + " = " + key.getValue());
        }
        System.out.println("++++++++++++++++++++++++");

        System.out.println("Received Page:");

        try(InputStream in = con.getInputStream()) {
            byte[] buf = new byte[64 * 1024];
            while (true) {
                int count = in.read(buf);
                if (count != -1) {
                    String page = new String(buf, 0, count, "UTF-8");
                    System.out.println(page);
                }
                else {
                    return;
                }
            }
        }
    }
}
//data-aria-label-part="0"
//найдётся твит по этому запросу