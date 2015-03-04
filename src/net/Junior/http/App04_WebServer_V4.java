package net.Junior.http;

import com.sun.net.httpserver.*;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.spi.HttpServerProvider;
import sun.net.httpserver.*;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;

/**
* Created by root on 04.03.2015.
*/
public class App04_WebServer_V4 {
    //создаём упорядоченную карту, которая запоминает последовательность добавления страниц
    protected static Map<String, String> allLinks = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        //максимальное количество одновременных подключений (кол-во работающих потоков)
        int maxConnections = 64;
        //порт, на котором будет работать сервер
        InetSocketAddress socketAddress = new InetSocketAddress(80);
        //добавляем в мапу отображаемое имя ссылки и адрес куда она ссылается
        allLinks.put("Первая страница", "/first.html");
        allLinks.put("Вторая страница", "/second.html");
        allLinks.put("Третья страница", "/third.html");
        allLinks.put("Главная страница", "/");

        HttpServerProvider serverProvider = DefaultHttpServerProvider.provider();
        HttpServer server = serverProvider.createHttpServer(socketAddress, maxConnections);

        /*
        Создаём контекст. Это делается для того, чтобы избежать больших свичей или проверок else if. Когда на сервер
        приходит запрос типа "/" или "/first.html", то сервер сразу же запускает обработчик именно этого запроса
         */
        HttpContext baseContext = server.createContext("/");
        //создаём обработчик к запросу выше
        baseContext.setHandler(new PageHandler("Привет, это главная страница"));

        HttpContext firstPageContext = server.createContext("/first.html");
        firstPageContext.setHandler(new PageHandler("Это первая страница"));

        HttpContext secondPageContext = server.createContext("/second.html");
        secondPageContext.setHandler(new PageHandler("А это уже вторая страница"));

        HttpContext thirdPageContext = server.createContext("/third.html");
        thirdPageContext.setHandler(new PageHandler("И наконец вот третья страница"));

        //запускаем сервер
        server.start();
    }
}

/*
Класс-обработчик запроса. В нём введена как бы рыба документа. В нём тело одно и тоже, меняется только содержимое,
предаваемое обработчиком
 */
class PageHandler implements HttpHandler {
    private String httpPage;
    private String text;

    PageHandler(String text) {
        this.text = text;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        //отображает запрошенный клиентом ЮРЛ
        String requestedURL = exchange.getRequestURI().toString();
        System.out.println("Запросили: " + requestedURL);

        httpPage = createPage(requestedURL);
        exchange.sendResponseHeaders(200, httpPage.length());
        OutputStream out = exchange.getResponseBody();
        out.write(httpPage.getBytes(Charset.forName("windows-1251")));
        out.close();
    }

    //мотод - простроитель html страницы
    private String createPage(String url) {
        //на добавлениях StringBuilder работает быстрее чем String, т.к. это один и тот же объект
        StringBuilder page = new StringBuilder();
        //лепим верхнюю часть страницы
        page.append(
                "<html>\n" +
                "   <body>\n" +
                "       <p>" + text + "</p>\n"
        );
        //проходим по карте ссылок и выводим все ссылки на другие страницы, кроме страницы, на который мы сейчас находимся
        for (Map.Entry<String, String> link : App04_WebServer_V4.allLinks.entrySet()) {
            String linkName = link.getKey();
            String linkTo = link.getValue();
            if (!url.equals(linkTo)) {
                page.append("           <p><a href=\"" + linkTo + "\">" + linkName + "</a></p>\n");
            }
        }
        //лепим нижнюю часть страницы
        page.append(
                "   </body>\n" +
                "</html>"
        );
        return page.toString();
    }
}
/*
Такой же карманный сервер, только слегка улучшеный
 */