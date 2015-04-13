package net.Horstmann_Example_T2.Chapter3_Network;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by root on 13.04.2015.
 */
public class App02_URLConnection {
    private static final String USER_NAME = "kharmet";
    private static final String USER_PASSWORD = "9NCzR##?3z";
    private static String urlStr = "http://gcst.meteo.gov.ua/armua/index.phtml";

    public static void main(String[] args) throws IOException {
        URL url = new URL(urlStr);
        URLConnection connection = url.openConnection();

        //преобразовать логин и пароль по Base64
        String accessKey = USER_NAME + ":" + USER_PASSWORD;
        String encodedAccessKey = Base64.getEncoder().encodeToString(accessKey.getBytes());

        //свойства запроса

        //поток для чтения данных с сервера, можно не устанавливать, по умолчанию всегда true
        connection.setDoInput(true);
        //поток для записи данных на сервер, если будем туда что-то писать, то надо установить true, по умолчанию всегда false
        connection.setDoOutput(false);
        //можно по желанию устанавливать ряд заголовков запросов
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:37.0) Gecko/20100101 Firefox/37.0");
        connection.setRequestProperty("Authorization", "Basic " + encodedAccessKey);
        //можно установить время ожидания соединения
        connection.setConnectTimeout(2 * 60 * 1000);//ожидать соединение 2 мин
        //можно установить время чтения данных из канала, т.е. читать данные не больше указанного времени
        connection.setReadTimeout(1 * 60 * 1000);//читать из канала не дольше 1 мин

        //можно посмотреть сформированный запрос
        System.out.println("Заголовки запроса:");
        Map<String, List<String>> requestProperties = connection.getRequestProperties();
        for (Map.Entry<String, List<String>> entry : requestProperties.entrySet()) {
            String key = entry.getKey();
            for (String value : entry.getValue()) {
                System.out.println(key + " : " + value);
            }
        }
        System.out.println("----------------------\n");

        //установить соединение
        connection.connect();

        //вывести заголовки ответа

        //при помощи перебора значений
        System.out.println("Заголовки ответа при помощи перебора значений:");
        //ВНИМАНИЕ! Нумерация заголовков начинается с 1, а не с 0!
        for (int i = 1; connection.getHeaderField(i) != null; i++) {
            System.out.println(connection.getHeaderField(i));
        }
        System.out.println("----------------------\n");

        //при помощи мапы
        System.out.println("Заголовки ответа при помощи мапы:");
        Map<String, List<String>> headerFields = connection.getHeaderFields();
        for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
            String key = entry.getKey();
            for (String value : entry.getValue()) {
                System.out.println(key + " : " + value);
            }
        }
        System.out.println("----------------------\n");

        //при помощи служебных методов
        System.out.println("Заголовки ответа при помощи служебных методов:");
        System.out.println("ContentType: " + connection.getContentType());
        System.out.println("ContentLength: " + connection.getContentLength());
        System.out.println("ContentEncoding: " + connection.getContentEncoding());
        System.out.println("Date: " + connection.getDate());
        System.out.println("Expiration: " + connection.getExpiration());
        System.out.println("LastModified: " + connection.getLastModified());
        System.out.println("----------------------\n");

        //вывести страницу
        System.out.println("Вывести страницу полностью:");
        Scanner in = new Scanner(connection.getInputStream(), "koi8-u");
        while (in.hasNextLine()) {
            System.out.println(in.nextLine());
        }
        System.out.println("----------------------\n");
    }
}
/*
Пробуем залогиниться на http://gcst.meteo.gov.ua/armua/index.phtml, чтобы убедиться в том, что мы точно вошли,
на странице с ответом должен быть логин: kharmet.
 */