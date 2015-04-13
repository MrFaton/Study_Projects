package net.Horstmann_Example_T2.Chapter3_Network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by root on 13.04.2015.
 */
public class App03_URLConnection_POST {
    private static final String USER_NAME = "kharmet";
    private static final String USER_PASSWORD = "9NCzR##?3z";
    private static String postUrlStr = "http://gcst.meteo.gov.ua/armua/jornal/show.phtml";//куда будем отправлять запрос
    private static String telegramHeader = "САУР*КИХА";//что ищем
    private static String telegramTerm = "";//за какой срок
    private static String telegramDip = "1";//глубина поиска в сутках
    private static String telegramSrok = "2015-04-12 14:45:14";//начиная с этой даты

    public static void main(String[] args) throws IOException {
        //преобразовать логин и пароль по Base64
        String accessKey = USER_NAME + ":" + USER_PASSWORD;
        String encodedAccessKey = Base64.getEncoder().encodeToString(accessKey.getBytes());

        //что мы будем отправлять в POST запросе на сервер
        Map<String, String> postParameters = new LinkedHashMap<>();
        postParameters.put("find", URLEncoder.encode(telegramHeader, "koi8-u"));//на gcst используется koi8-u, но вообще на всех нормальных сайтах используеют UTF-8
        postParameters.put("find1", telegramTerm);
        postParameters.put("dip", telegramDip);
        postParameters.put("srok", URLEncoder.encode(telegramSrok, "koi8-u"));//на gcst используется koi8-u, но вообще на всех нормальных сайтах используеют UTF-8

        URL url = new URL(postUrlStr);
        URLConnection connection = url.openConnection();

        //можно по желанию устанавливать ряд заголовков запросов
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:37.0) Gecko/20100101 Firefox/37.0");
        connection.setRequestProperty("Authorization", "Basic " + encodedAccessKey);
//
        //можно установить время ожидания соединения
        connection.setConnectTimeout(2 * 60 * 1000);//ожидать соединение 2 мин
        //можно установить время чтения данных из канала, т.е. читать данные не больше указанного времени
        connection.setReadTimeout(3 * 60 * 1000);//читать из канала не дольше 3 мин

        //поток для чтения данных с сервера, можно не устанавливать, по умолчанию всегда true
        connection.setDoInput(true);
        //поток для записи данных на сервер, т.к. у нас метод POST, значит нужно true, хотя по умолчанию false
        connection.setDoOutput(true);

        //отправить на сервер ПОСТ запрос
        try (PrintWriter writer = new PrintWriter(connection.getOutputStream())) {
            boolean firstEntry = true;
            for (Map.Entry<String, String> entry : postParameters.entrySet()) {
                if (firstEntry) {
                    firstEntry = false;
                } else {
                    writer.print('&');
                }
                writer.print(entry.getKey());
                writer.print('=');
                writer.print(entry.getValue());
            }
        }


        //прочитать ответ от сервера
        try (Scanner input = new Scanner(connection.getInputStream(), "koi8-u")) {
            while (input.hasNextLine()) {
                System.out.println(input.nextLine());
            }
        }
    }
}
/*
Как я брал параметры для запроса POST.
Открыл исходный код страницы http://gcst.meteo.gov.ua/armua/jornal/show.phtml.
Нашёл там поля, в которые вводятся данные и взял их имена:
<td colspan="2" align="center" nowrap> <form action="show.phtml"
method="POST" accept-charset="koi8-u">
  Пошук по скороченому  <br>
заголовку:<input type="text" name="find" size=20 value="САУР*КИХА" > ----------первое поле find
терміну:<input type="text" name="find1" size=20 value="" > --------------------второе поле find1
<br><br>

Глибина пошуку:<select name="dip"> --------------------------------------------третье поле dip
        <option value="1">1 сутки
        <option value="2">2 суток
        <option value="5">5 суток
        <option value="10">10 суток
        <option value="20">20 суток
        <option value="30">1 місяць
        <option value="60">2 місяці
            </select> Починаючи з <input  type="input" size=15 name=srok -----четвёрное поле srok
value="2015-04-12 09:45:14" ><br><br>

<input class=send type="submit" name="sub" value="       Знайти        ">
<input class=send type="reset" value="     Зтерти     ">
                     </form>

    </td>

Так же это всё можно увидеть, если отправить запрос чере Файр Фокс и выбрать этот ПОСТ запрос и выбрать
изменить и повторить, там в теле запроса можно увидеть поля, которые он отправил

Сам поисковый запрос выглядит так:
find=%F3%E1%F5%F2*%EB%E9%E8%E1&find1=&dip=1&srok=2015-04-12+11%3A45%3A14
 */