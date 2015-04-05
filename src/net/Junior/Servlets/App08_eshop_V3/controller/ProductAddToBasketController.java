package net.Junior.Servlets.App08_eshop_V3.controller;

import net.Junior.Servlets.App08_eshop_V3.dao.ProductDAO;
import net.Junior.Servlets.App08_eshop_V3.dao.exceptions.DAOSystemException;
import net.Junior.Servlets.App08_eshop_V3.dao.exceptions.NoSuchEntityException;
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
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Mr_Faton on 05.04.2015.
 */
public class ProductAddToBasketController extends HttpServlet {
    private ProductDAO productDAO = new ProductDAOImpl();
    private static final SessionOnServerRepository sessionOnServerRepository = SessionOnServerRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productIDStr = request.getParameter(Statements.PARAM_ID);
        Session_User session_user;
        String sessionId;
        if (productIDStr != null) {
            try {
                int productID = Integer.valueOf(productIDStr);
                Product product = productDAO.selectById(Integer.valueOf(productID));

                CookieFinder cookieFinder = new CookieFinder();
                Cookie jsessionid_cookie = cookieFinder.findCookieByName(Statements.COOKIE_JSESSIONID, request);

                if (jsessionid_cookie != null) {
                    sessionId = jsessionid_cookie.getValue();
                } else {
                    sessionId = sessionOnServerRepository.createSession();
                    jsessionid_cookie = new Cookie(Statements.COOKIE_JSESSIONID, sessionId);
                }

                session_user = sessionOnServerRepository.getSessionById(sessionId);
                Map<Product, Integer> basket = (Map<Product, Integer>) session_user.get(Statements.ATTRIBUTE_BASKET);
                if (basket == null) {
                    basket = new LinkedHashMap<>();
                }
                int numOfProducts = 0;
                if (basket.containsKey(product)) {
                    numOfProducts = basket.get(product);
                }
                numOfProducts++;
                basket.put(product, numOfProducts);
                session_user.put(Statements.ATTRIBUTE_BASKET, basket);
                session_user.setExpiration();

                jsessionid_cookie.setMaxAge(Statements.COOKIE_LIFETIME);//время жизни в секундах
                response.addCookie(jsessionid_cookie);
                response.sendRedirect(Statements.URI_PRODUCT + productID);
                return;
            } catch (NumberFormatException | NoSuchEntityException | DAOSystemException ex) {/*NOP*/}
        }
        response.sendRedirect(Statements.PAGE_ERROR);
    }
}
