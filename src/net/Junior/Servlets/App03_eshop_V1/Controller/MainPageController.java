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
        String requestURI = req.getRequestURI();
        System.out.println(req.getRequestURI());
        if (requestURI.equals("/") || requestURI.equals("/main") || requestURI.equals("/main.do")) {
            req.getRequestDispatcher(Statements.PAGE_MAIN).forward(req, resp);
        } else {
            resp.sendRedirect(Statements.PAGE_ERROR);
        }
        return;
    }
}
