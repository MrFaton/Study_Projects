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
import java.util.Map;

/**
 * Created by Mr_Faton on 06.04.2015.
 */
public class ProductRemoveFromBasketController extends HttpServlet {
    //как бы наша БД с продукутами
    private ProductDAO productDAO = new ProductDAOImpl();
    //хранилище сессий на сервере
    private SessionOnServerRepository sessionOnServerRepository = SessionOnServerRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //получаем значение ид продукта из запроса
        String idStr = request.getParameter(Statements.PARAM_ID);
        //строкове ид сессии клиента
        String sessionId;
        //сессия клиента
        Session_User session_user;
        //если в запросе был параметр ид
        if (idStr != null) {
            try {
                //пытаемся получить значение ид в виде int из String
                int productID = Integer.valueOf(idStr);
                //получаем продукт по этому ид из БД
                Product product = productDAO.selectById(productID);

                //получаем сессию клиента

                //класс, который ищек куку по её имени
                CookieFinder cookieFinder = new CookieFinder();
                //кука с ид сессии клиента
                Cookie jsessionid_cookie = cookieFinder.findCookieByName(Statements.COOKIE_JSESSIONID, request);

                //если у клиента есть кука с ид сессией
                if (jsessionid_cookie != null) {
                    //получаем ид сессии из куки
                    sessionId = jsessionid_cookie.getValue();

                    //получаем сессию клиента по её ид из хранилища сессий на сервере
                    session_user = sessionOnServerRepository.getSessionById(sessionId);
                    //вытягиваем коризину с покупками клиента
                    Map<Product, Integer> basket = (Map<Product, Integer>) session_user.get(Statements.ATTRIBUTE_BASKET);

                    //если корзина покупок пользователя не пуста (посути она не может НЕ пустой, т.к. пользователь удаляет товар из корзины)
                    if (basket != null) {
                        //если коризна покупок содержит продукт (посути корзина должна содержать этот продукт)
                        if (basket.containsKey(product)) {
                            //колличество штук данного продукта
                            int numOfProducts = basket.get(product);
                            //если данный продукт всего 1
                            if (numOfProducts == 1) {
                                //то удаляем этот продукт из корзины
                                basket.remove(product);
                                //если это был последний продукт
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
                            //продлеваем жизнь сессии пользователя на сервере
                            session_user.setExpiration();
                            //продлеваем жизнь куки на браузере
                            jsessionid_cookie.setMaxAge(Statements.COOKIE_LIFETIME);//время жизни в секундах
                            //добавляем куку к ответу
                            response.addCookie(jsessionid_cookie);
                        }
                    }
                }
                //деляем редирект на тот продукт, который удалялся
                response.sendRedirect(Statements.URI_PRODUCT + productID);
                return;
            } catch (NumberFormatException | NoSuchEntityException | DAOSystemException ex) {/*NOP*/}
        }
        response.sendRedirect(Statements.PAGE_ERROR);
    }
}
/*
Как работает объект этого класса.
Этот класс удаляет определённый тип продукта из корзины (Хлеб, Масло, Сыр).
JSP строит ссылки типа "/productRemoveFromBasket.do?id=1" (1 - если на странице хлеба).
Когда мы в браузере клацаем по этой ссылке, мы попадаем на этот сервлет. ЮРЛ в браузере меняется на ЮРЛ ссылки.
Этот сервет пытается получить ид сессии из куки, если куки нет или нет сессии на сервере с таким ид, то он
создаёт сессию в хранилище, затем получает доступ к это сессии клинета по её ид. Вытягивает от туда корзину
покупок пользователя и смотрит колличество (сколько штук) данного товара находится в корзине. Если в корзине остался
всего лишь один такой товар, то он удаляет из корзины этот товар, если больше чем 1, то он уменьшает на 1 колличество
данных товаров. Далее ложит обновлённый список товаров в корзиру, корзину в сессию. И делает Редирект на страницу
с продуктом "/product.do?id=1". ЮРЛ снова меняется. Смена ЮРЛов происходит так быстро, что кажется что мы
оставались на стринице с продуктом.
 */