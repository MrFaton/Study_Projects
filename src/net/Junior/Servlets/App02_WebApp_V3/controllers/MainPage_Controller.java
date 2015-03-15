package net.Junior.Servlets.App02_WebApp_V3.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by root on 12.03.2015.
 */
public class MainPage_Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Hi! I am Servlet at the main page and I am fine!");
    }
}
