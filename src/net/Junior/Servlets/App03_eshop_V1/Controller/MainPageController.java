package net.Junior.Servlets.App03_eshop_V1.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mr_Faton on 15.03.2015.
 */
public class MainPageController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //получаем запрос
        String requestURI = req.getRequestURI();
        System.out.println(req.getRequestURI());
        if (requestURI.equals("/") || requestURI.equals("/main") || requestURI.equals("/main.do")) {
            /*
            Если ЮРИ запроса "/" или "/main" или "/main.do" делаем внутренний редирек (ЮРИ введённое пользователем
            НЕ меняется) на главную страницу
             */
            req.getRequestDispatcher(Statements.PAGE_MAIN).forward(req, resp);
        } else {
            //если if вернул false (клиент ввёл плохой зарос) делаем внешний редирект (ЮРЛ меняется) на страницу ошибки
            resp.sendRedirect(Statements.PAGE_ERROR);
        }
        return;
    }
}
/*
Сервлет, который обрабатывает запросы, попавшие на "/".
 */