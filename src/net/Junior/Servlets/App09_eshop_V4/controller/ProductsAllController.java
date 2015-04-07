package net.Junior.Servlets.App09_eshop_V4.controller;

import net.Junior.Servlets.App09_eshop_V4.dao.ProductDAO;
import net.Junior.Servlets.App09_eshop_V4.dao.exceptions.DAOSystemException;
import net.Junior.Servlets.App09_eshop_V4.dao.implementation.ProductDAOImpl;
import net.Junior.Servlets.App09_eshop_V4.entity.CookieFinder;
import net.Junior.Servlets.App09_eshop_V4.entity.Product;
import net.Junior.Servlets.App09_eshop_V4.session.SessionOnClientRepository;
import net.Junior.Servlets.App09_eshop_V4.session.Session_User;
import net.Junior.Servlets.App09_eshop_V4.statements.Statements;

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
    private SessionOnClientRepository sessionOnClientRepository = new SessionOnClientRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestedURI = request.getRequestURI();
        if (requestedURI.equals(Statements.URI_MAIN_1) || requestedURI.equals(Statements.URI_MAIN_2)) {
            CookieFinder cookieFinder = new CookieFinder();
            try {
                Cookie sessionCookie = cookieFinder.findCookieByName(Statements.COOKIE_MY_SESSION, request);
                if (sessionCookie != null) {
                    System.out.println("-----> User has got a session cookie");
                    Session_User session_user = sessionOnClientRepository.getSessionByCookie(sessionCookie, false);
                    if (session_user != null) {
                        session_user.setExpiration();
                        Map<Product, Integer> basket =
                                (Map<Product, Integer>) session_user.get(Statements.ATTRIBUTE_BASKET);
                        request.setAttribute(Statements.ATTRIBUTE_BASKET, basket);
                        sessionCookie.setMaxAge(Statements.COOKIE_LIFETIME);//время жизни в секундах
                        response.addCookie(sessionCookie);
                    }
                } else {
                    System.out.println("-----> User hasn't got a cookie, don't create session");
                }
                request.setAttribute(Statements.ATTRIBUTE_PRODUCTS_LIST, productDAO.selectAll());
                request.getRequestDispatcher(Statements.PAGE_MAIN).forward(request, response);
                return;
            } catch (DAOSystemException ex) {/*NOP*/}
        }
        response.sendRedirect(Statements.PAGE_ERROR);
    }
}