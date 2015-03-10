package net.Junior.Servlets.WebApp_V1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mr_Faton on 10.03.2015.
 */
public class BaseController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(">> Base: send answer");
        String message = "" +
                "<html>\n" +
                "   <title>Это главная страница</title>\n" +
                "   <body>\n" +
                "       <p><font size = \"6\">Привет. Сервлет работает! Это главная страница</font></p>\n" +
                /*описание строки /test/another.do, смотри внизу*/
                "       <p><font size = \"5\"><a href = \"/test/another.do\">Ещё одна страница на сервере<a></font><p>\n" +
                "   </body>\n" +
                "<html>";
        byte[] str = message.getBytes("windows-1251");
        response.getOutputStream().write(str);
        // также можно было ответить клиенту и таким образом
//        response.getWriter().write("Hello");
    }
}
/*
Почему ссылка на другую страницу выглядит так: "/test/another.do", хотя должна была бы выглядеть так:
"/another.do". Дело в том, что Томкет настраен таким образом, что корневым URL для него является название веб архива.
Так как я назвал веб архив "test.war", то нужно подставлять в ЮРЛ test.
 */