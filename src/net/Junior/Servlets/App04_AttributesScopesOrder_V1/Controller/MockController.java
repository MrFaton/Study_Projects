package net.Junior.Servlets.App04_AttributesScopesOrder_V1.Controller;

import net.Junior.Servlets.App04_AttributesScopesOrder_V1.Bean.MockBeanAA;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mr_Faton on 18.03.2015.
 */
public class MockController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //добавляем атрибут в request
        request.setAttribute("testAttr", "Request attribute");
        //добавляем атрибут в session
        request.getSession().setAttribute("testAttr", "Session attribute");
        //добавляем атрибут в servletContext
        request.getServletContext().setAttribute("testAttr", "ServletContext attribute");

        /*
        Рассмотрим поля бинов. Потом на jsp будет показано как работать с полями бинов (классов у которые есть
        только поля, геттеры, сеттеры и максимум equals, hashCode и toString) Как из них получать данные
         */
        request.setAttribute("requestAttribute", new MockBeanAA());
        request.getSession().setAttribute("sessionAttribute", new MockBeanAA());
        request.getServletContext().setAttribute("servletContextAttribute", new MockBeanAA());

        request.getRequestDispatcher("testAttributes.jsp").forward(request, response);
    }
}
/*
Области видимости атрибутов на jsp устроены так, что сначала атрибут с заданным именем ищется на странице jsp,
если его там нет, то ищется у request, если его там нет, то у session, если его там нет, то у servletContext
 */