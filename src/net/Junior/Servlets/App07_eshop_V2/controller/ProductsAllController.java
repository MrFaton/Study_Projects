package net.Junior.Servlets.App07_eshop_V2.controller;

import net.Junior.Servlets.App07_eshop_V2.dao.ProductDAO;
import net.Junior.Servlets.App07_eshop_V2.dao.exceptions.DAOSystemException;
import net.Junior.Servlets.App07_eshop_V2.dao.implementation.ProductDAOImpl;
import net.Junior.Servlets.App07_eshop_V2.entity.CookieFinder;
import net.Junior.Servlets.App07_eshop_V2.session.SessionOnServerRepository;
import net.Junior.Servlets.App07_eshop_V2.statements.Statements;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by Mr_Faton on 27.03.2015.
 */
public class ProductsAllController extends HttpServlet {
    private final ProductDAO productDAO = new ProductDAOImpl();
    private static final SessionOnServerRepository sessionOnServerRepository = new SessionOnServerRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestedURI = request.getRequestURI();
        if (requestedURI.equals(Statements.URI_MAIN_1) || requestedURI.equals(Statements.URI_MAIN_2)) {
            CookieFinder cookieFinder = new CookieFinder();
            try {

                System.out.println("+++++> Sessions List");
                Iterator<String> sesIter = sessionOnServerRepository.getSessionList();
                while (sesIter.hasNext()) {
                    System.out.println("+++++> " + sesIter.next());
                }
                System.out.println("+++++> End of Sessions List");

                Cookie jsessionid_cookie = cookieFinder.findCookieByName(Statements.COOKIE_JSESSIONID, request);
                if (jsessionid_cookie != null) {
                    System.out.println("-----> User has got a cookie: " + jsessionid_cookie.getValue());
                } else {
                    System.out.println("-----> User hasn't got a cookie, try to create it");
                    String sessionId = sessionOnServerRepository.createSession();
                    System.out.println("----> " + sessionId);
                    System.out.println("----> creating finish");
                    jsessionid_cookie = new Cookie(Statements.COOKIE_JSESSIONID, sessionId);
                    jsessionid_cookie.setValue("Кука для доступа к сесси на сервере");
                    jsessionid_cookie.setMaxAge(600);//время жизни в секундах, тут 10 мин (60*10)
                    response.addCookie(jsessionid_cookie);
                }
                request.setAttribute(Statements.ATTRIBUTE_PRODUCTS_LIST, productDAO.selectAll());
                request.getRequestDispatcher(Statements.PAGE_MAIN).forward(request, response);
                return;
            } catch (DAOSystemException exception) {
                System.err.println("Проблемы с БД");
            }
        }
        response.sendRedirect(Statements.PAGE_ERROR);
    }
}
/*
jsessionid_cookie.setMaxAge(int x);, тут х - время жизни куки на браузере в секундах
 */