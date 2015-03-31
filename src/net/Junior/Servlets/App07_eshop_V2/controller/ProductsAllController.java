package net.Junior.Servlets.App07_eshop_V2.controller;

import net.Junior.Servlets.App07_eshop_V2.dao.ProductDAO;
import net.Junior.Servlets.App07_eshop_V2.dao.exceptions.DAOSystemException;
import net.Junior.Servlets.App07_eshop_V2.dao.implementation.ProductDAOImpl;
import net.Junior.Servlets.App07_eshop_V2.entity.CookieFinder;
import net.Junior.Servlets.App07_eshop_V2.session.SessionOnServerRepository;
import net.Junior.Servlets.App07_eshop_V2.session.Session_User;
import net.Junior.Servlets.App07_eshop_V2.statements.Statements;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Mr_Faton on 27.03.2015.
 */
public class ProductsAllController extends HttpServlet {
    private final ProductDAO productDAO = new ProductDAOImpl();
    private static final SessionOnServerRepository sessionOnServerRepository = SessionOnServerRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestedURI = request.getRequestURI();
        if (requestedURI.equals(Statements.URI_MAIN_1) || requestedURI.equals(Statements.URI_MAIN_2)) {
            CookieFinder cookieFinder = new CookieFinder();
            try {
                Cookie jsessionid_cookie = cookieFinder.findCookieByName(Statements.COOKIE_JSESSIONID, request);
                if (jsessionid_cookie != null) {
                    System.out.println("-----> User has got a cookie: " + jsessionid_cookie.getValue());
                } else {
                    System.out.println("-----> User hasn't got a cookie, try to create it");
                    String sessionId = sessionOnServerRepository.createSession();
                    System.out.println("----> " + sessionId);
                    System.out.println("----> creating finish");
                    jsessionid_cookie = new Cookie(Statements.COOKIE_JSESSIONID, sessionId);
//                    jsessionid_cookie.setComment("Кука для доступа к сесси на сервере");
                    jsessionid_cookie.setMaxAge(600);//время жизни в секундах, тут 10 мин (10*60)
                    response.addCookie(jsessionid_cookie);
                }

                System.out.println("+++++> Sessions List");
                for (Map.Entry<String, Session_User> element : sessionOnServerRepository.getSessionsMap().entrySet()) {
                    System.out.println(element.getKey());
                }
                System.out.println("+++++> End of Sessions List");

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