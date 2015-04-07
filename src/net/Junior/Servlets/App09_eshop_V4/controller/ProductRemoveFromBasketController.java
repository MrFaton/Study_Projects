package net.Junior.Servlets.App09_eshop_V4.controller;

import net.Junior.Servlets.App09_eshop_V4.dao.ProductDAO;
import net.Junior.Servlets.App09_eshop_V4.dao.exceptions.DAOSystemException;
import net.Junior.Servlets.App09_eshop_V4.dao.exceptions.NoSuchEntityException;
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
 * Created by Mr_Faton on 06.04.2015.
 */
public class ProductRemoveFromBasketController extends HttpServlet {
    private ProductDAO productDAO = new ProductDAOImpl();
    private SessionOnClientRepository sessionOnClientRepository = SessionOnClientRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter(Statements.PARAM_ID);
        String sessionId;
        Session_User session_user;
        if (idStr != null) {
            try {
                int productID = Integer.valueOf(idStr);
                Product product = productDAO.selectById(productID);

                CookieFinder cookieFinder = new CookieFinder();
                Cookie jsessionid_cookie = cookieFinder.findCookieByName(Statements.COOKIE_JSESSIONID, request);

                if (jsessionid_cookie != null) {
                    sessionId = jsessionid_cookie.getValue();

                    session_user = sessionOnClientRepository.getSessionById(sessionId);
                    Map<Product, Integer> basket = (Map<Product, Integer>) session_user.get(Statements.ATTRIBUTE_BASKET);

                    if (basket != null) {
                        if (basket.containsKey(product)) {
                            int numOfProducts = basket.get(product);
                            if (numOfProducts == 1) {
                                basket.remove(product);
                                if (basket.isEmpty()) {
                                    basket = null;
                                }
                            } else {
                                numOfProducts--;
                                basket.put(product, numOfProducts);
                            }
                            if (basket != null) {
                                session_user.put(Statements.ATTRIBUTE_BASKET, basket);
                            } else {
                                session_user.remove(Statements.ATTRIBUTE_BASKET);
                            }
                            session_user.setExpiration();
                            jsessionid_cookie.setMaxAge(Statements.COOKIE_LIFETIME);//время жизни в секундах
                            response.addCookie(jsessionid_cookie);
                        }
                    }
                }
                response.sendRedirect(Statements.URI_PRODUCT + productID);
                return;
            } catch (NumberFormatException | NoSuchEntityException | DAOSystemException ex) {/*NOP*/}
        }
        response.sendRedirect(Statements.PAGE_ERROR);
    }
}
