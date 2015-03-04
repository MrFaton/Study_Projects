package net.Junior.http;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.spi.HttpServerProvider;
import sun.net.httpserver.*;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

/**
 * Created by root on 04.03.2015.
 */
public class App03_WebServer_V3 {
    public static void main(String[] args) throws IOException {
        final int backlog = 64;
        final InetSocketAddress socketAddress = new InetSocketAddress(80);

        HttpServerProvider serverProvider = DefaultHttpServerProvider.provider();
        HttpServer server = serverProvider.createHttpServer(socketAddress, backlog);

        HttpContext baseContext = server.createContext("/");
        baseContext.setHandler(new PageHttpHandler("" +
                "<html>\n" +
                "   <body>\n" +
                "       <p>Hi! This is main page!</p>\n" +
                "       <p><a href=\"/first.go\">To first page</a></p>\n" +
                "       <p><a href=\"/second.go\">To second page</a></p>\n" +
                "   </body>\n" +
                "</html>"
        ));

        HttpContext firstPageContext = server.createContext("/first.go");
        firstPageContext.setHandler(new PageHttpHandler("" +
                "<html>\n" +
                "   <body>\n" +
                "       <p>Hi! This is first page!</p>\n" +
                "       <p><a href=\"/second.go\">To second page</a></p>\n" +
                "   </body>\n" +
                "</html>"
        ));

        HttpContext secondPageContext = server.createContext("/second.go");
        secondPageContext.setHandler(new PageHttpHandler("" +
                "<html>\n" +
                "   <body>\n" +
                "       <p>Hi! This is second page!</p>\n" +
                "       <p><a href=\"/first.go\">To first page</a></p>\n" +
                "   </body>\n" +
                "</html>"
        ));

        server.start();
    }
}

class PageHttpHandler implements HttpHandler {
    private final String httpPage;

    PageHttpHandler(String httpPage) {
        this.httpPage = httpPage;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        httpExchange.sendResponseHeaders(200, httpPage.length());
        OutputStream out = httpExchange.getResponseBody();
        out.write(httpPage.getBytes(StandardCharsets.US_ASCII));
        out.close();
    }
}
/*
Так сказать карманный HTTP сервер, который поставляется компанией sun
 */
