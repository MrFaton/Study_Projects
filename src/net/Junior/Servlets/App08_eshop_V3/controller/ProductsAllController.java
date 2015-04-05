package net.Junior.Servlets.App08_eshop_V3.controller;

import net.Junior.Servlets.App08_eshop_V3.dao.ProductDAO;
import net.Junior.Servlets.App08_eshop_V3.dao.exceptions.DAOSystemException;
import net.Junior.Servlets.App08_eshop_V3.dao.implementation.ProductDAOImpl;
import net.Junior.Servlets.App08_eshop_V3.entity.CookieFinder;
import net.Junior.Servlets.App08_eshop_V3.entity.Product;
import net.Junior.Servlets.App08_eshop_V3.session.SessionOnServerRepository;
import net.Junior.Servlets.App08_eshop_V3.session.Session_User;
import net.Junior.Servlets.App08_eshop_V3.statements.Statements;

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
    private static final ProductDAO productDAO = new ProductDAOImpl();
    private static final SessionOnServerRepository sessionOnServerRepository = SessionOnServerRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestedURI = request.getRequestURI();
        if (requestedURI.equals(Statements.URI_MAIN_1) || requestedURI.equals(Statements.URI_MAIN_2)) {
            CookieFinder cookieFinder = new CookieFinder();
            try {
                Cookie jsessionid_cookie = cookieFinder.findCookieByName(Statements.COOKIE_JSESSIONID, request);
                if (jsessionid_cookie != null) {
                    String sessionId = jsessionid_cookie.getValue();
                    System.out.println("-----> User has got a cookie: " + sessionId);
                    Session_User session_user = sessionOnServerRepository.getSessionById(sessionId, false);
                    if (session_user != null) {
                        session_user.setExpiration();
                        Map<Product, Integer> basket =
                                (Map<Product, Integer>) session_user.get(Statements.ATTRIBUTE_BASKET);
                        request.setAttribute(Statements.ATTRIBUTE_BASKET, basket);
                        jsessionid_cookie.setMaxAge(Statements.COOKIE_LIFETIME);//время жизни в секундах
                        response.addCookie(jsessionid_cookie);
                    } else {
                        System.out.println("-----> But JSESSIONID doesn't find on server " + sessionId);
                    }
                } else {
                    System.out.println("-----> User hasn't got a cookie, don't create session");
                }

                System.out.println("\n+++++> Sessions List");
                for (Map.Entry<String, Session_User> element : sessionOnServerRepository.getSessionsMap().entrySet()) {
                    System.out.println(element.getKey());
                }
                System.out.println("+++++> End of Sessions List\n");

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