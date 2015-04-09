package net.Junior.Servlets.App09_eshop_V4.controller;

import net.Junior.Servlets.App09_eshop_V4.dao.ProductDAO;
import net.Junior.Servlets.App09_eshop_V4.dao.exceptions.DAOSystemException;
import net.Junior.Servlets.App09_eshop_V4.dao.exceptions.NoSuchEntityException;
import net.Junior.Servlets.App09_eshop_V4.dao.implementation.ProductDAOImpl;
import net.Junior.Servlets.App09_eshop_V4.entity.CookieFinder;
import net.Junior.Servlets.App09_eshop_V4.entity.Product;
import net.Junior.Servlets.App09_eshop_V4.entity.cookie.exceptions.CookieCreateException;
import net.Junior.Servlets.App09_eshop_V4.session.SessionOnClientRepository;
import net.Junior.Servlets.App09_eshop_V4.session.Session_User;
import net.Junior.Servlets.App09_eshop_V4.session.exceptions.NoSuchSessionException;
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
    //как бы наша БД с продукутами
    private ProductDAO productDAO = new ProductDAOImpl();
    //объект этого касса позволяет нам работать с сессией клиента через его куки
    private SessionOnClientRepository sessionOnClientRepository = new SessionOnClientRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //получаем значение ид продукта из запроса
        String idStr = request.getParameter(Statements.PARAM_ID);
        //ищет куку по имени
        CookieFinder cookieFinder;
        //сессия клиента
        Session_User session_user;
        //если ид продукта есть
        if (idStr != null) {
            try {
                //получаем ид продукта в виде инта
                int productID = Integer.valueOf(idStr);
                //получаем продукт из БД
                Product product = productDAO.selectById(productID);

                //строим поисковик куков
                cookieFinder = new CookieFinder();
                //пытаемся получить куку с сессией пользователя
                Cookie sessionCookie = cookieFinder.findCookieByName(Statements.COOKIE_MY_SESSION, request);

                //если такая кука есть
                if (sessionCookie != null) {
                    try {
                        //пытаемся получить его сессию из его куки, но в случае не удачи не создаём новую сессию
                        session_user = sessionOnClientRepository.getSessionByCookie(sessionCookie, false);
                        //вытягиваем коризину с покупками клиента
                        Map<Product, Integer> basket =
                                (Map<Product, Integer>) session_user.get(Statements.ATTRIBUTE_BASKET);
                        //если корзина покупок пользователя не пуста (посути она не может НЕ пустой, т.к. пользователь удаляет товар из корзины)
                        if (basket != null) {
                            //если коризна покупок содержит продукт (посути корзина должна содержать этот продукт раз он удаляется)
                            if (basket.containsKey(product)) {
                                //колличество штук данного продукта
                                int numOfProducts = basket.get(product);
                                //если данный продукт всего 1 (Н: Хлеб = 1)
                                if (numOfProducts == 1) {
                                    //то удаляем этот продукт из корзины
                                    basket.remove(product);
                                    //если это был последний продукт в корзине и она пуста
                                    if (basket.isEmpty()) {
                                        //удаляем корзину (это нужно для jsp, чтобы ей легче было выводить страницу)
                                        basket = null;
                                    }
                                } else {
                                    //значит в корзине данных продуктов было больше чем 1
                                    //уменьшаем колличество штук данного продукта на 1
                                    numOfProducts--;
                                    //помещаем в корзину новое колличество штук данного продукта
                                    basket.put(product, numOfProducts);
                                }
                                //если корзина не пустая
                                if (basket != null) {
                                    //ложим корзину в сессию пользователя
                                    session_user.put(Statements.ATTRIBUTE_BASKET, basket);
                                } else {
                                    //значит корзина пустая
                                    //удаляем из сессии пользователя корзину с покупакми
                                    session_user.remove(Statements.ATTRIBUTE_BASKET);
                                }
                                try {
                                    //формируем новую куку с обновлённой сессией пользователя
                                    sessionCookie = sessionOnClientRepository.createSessionCookie(session_user);
                                    //устанавливаем время жизни куки
                                    sessionCookie.setMaxAge(Statements.COOKIE_LIFETIME);//время жизни в секундах
                                    //добавляем куку к ответу
                                    response.addCookie(sessionCookie);
                                } catch (CookieCreateException ignore) {/*NOP*/}
                            }
                        }
                    } catch (NoSuchSessionException ignore) {/*NOP*/}
                }
                //делаем редирект на страцу товара, который удаляли из корзины
                response.sendRedirect(Statements.URI_PRODUCT + productID);
                return;
            } catch (NumberFormatException | NoSuchEntityException | DAOSystemException ex) {/*NOP*/}
        }
        response.sendRedirect(Statements.PAGE_ERROR);
    }
}
