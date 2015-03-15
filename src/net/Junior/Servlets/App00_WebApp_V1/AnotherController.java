package net.Junior.Servlets.App00_WebApp_V1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mr_Faton on 10.03.2015.
 */
public class AnotherController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(">> Another: send answer");
        String message = "" +
                "<html>\n" +
                "   <title>Это другая страница</title>" +
                "   <body>\n" +
                "       <p><font size = \"6\">Привет! Это другая страница!</font></p>\n" +
                "       <p><font size = \"5\"><a href = \"/test\">Ссылка на главную страницу<a></font><p>\n" +
                "   </body>\n" +
                "<html>";
        byte[] str = message.getBytes("windows-1251");
        response.getOutputStream().write(str);
    }
}
