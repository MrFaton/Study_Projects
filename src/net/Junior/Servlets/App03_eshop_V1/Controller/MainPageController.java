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
    public static final String PARAM_ID = "id";
    public static final String ATTRIBUTE_TO_VIEW = "product";
    public static final String PAGE_MAIN = "main.jsp";
    public static final String PAGE_OK = "product.jsp";
    public static final String PAGE_ERROR = "error.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(PAGE_MAIN).forward(req, resp);
        return;
    }
}
