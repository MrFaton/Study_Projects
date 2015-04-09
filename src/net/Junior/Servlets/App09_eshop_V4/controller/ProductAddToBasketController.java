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
import java.util.LinkedHashMap;
import java.util.Map;

/**
* Created by Mr_Faton on 05.04.2015.
*/
public class ProductAddToBasketController extends HttpServlet {
    //как бы наша БД с продукутами
    private ProductDAO productDAO = new ProductDAOImpl();
    //объект этого касса позволяет нам работать с сессией клиента через его куки
    private SessionOnClientRepository sessionOnClientRepository = new SessionOnClientRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //получаем значение ид продукта из запроса
        String productIDStr = request.getParameter(Statements.PARAM_ID);
        //ищет куку по имени
        CookieFinder cookieFinder;
        //сессия клиента
        Session_User session_user;
        //если ид продукта есть
        if (productIDStr != null) {
            try {
                //получаем ид продукта в виде инта
                int productID = Integer.valueOf(productIDStr);
                //получаем продукт из БД
                Product product = productDAO.selectById(Integer.valueOf(productID));

                //строим поисковик куков
                cookieFinder = new CookieFinder();
                //пытаемся получить куку с сессией пользователя
                Cookie sessionCookie = cookieFinder.findCookieByName(Statements.COOKIE_MY_SESSION, request);

                //если такой куки у клиента нет
                if (sessionCookie == null) {
                    //создаём сессию для пользователя
                    session_user = new Session_User();
                } else {
                    //значит у клиента была кука с сессией
                    try{
                        //получаем сессию клиента из его куки
                        session_user = sessionOnClientRepository.getSessionByCookie(sessionCookie);
                    } catch (NoSuchSessionException ex) {
                        //если от клиента пришла плохая кука и восстановить его сессию не получилось, создаём новую сессию
                        session_user = new Session_User();
                    }
                }

                //вытягиваем коризину с покупками клиента
                Map<Product, Integer> basket = (Map<Product, Integer>) session_user.get(Statements.ATTRIBUTE_BASKET);
                //если корзина пользователя пуста (т.е. её вообще нет), то создаем ему новую корзину
                if (basket == null) {
                    basket = new LinkedHashMap<>();
                }
                //колличество купленного товара (например колличество купленого хлеба)
                int numOfProducts = 0;
                //если корзина содержит продукт который, пользователь себе добавляет (Н: в корзине уже был хлеб, клиент добавил ещё один)
                if (basket.containsKey(product)) {
                    //вытаскиваем колличество добавленных ранне продуктов этого типа (Н: сколько штук хлеба уже есть в корозине)
                    numOfProducts = basket.get(product);
                }
                //инкременируем на 1 колличество купленного продукта
                numOfProducts++;
                //ложим в корзину наш продукт и новое колличество штук этого продукта (Н: хлеб, 3 штуки)
                basket.put(product, numOfProducts);
                //ложим корзину в сессию пользователя
                session_user.put(Statements.ATTRIBUTE_BASKET, basket);

                try{
                    //формируем новую куку с обновлённой сессией пользователя
                    sessionCookie = sessionOnClientRepository.createSessionCookie(session_user);
                    //устанавливаем время жизни куки
                    sessionCookie.setMaxAge(Statements.COOKIE_LIFETIME);//время жизни в секундах
                    //добавляем куку к ответу
                    response.addCookie(sessionCookie);
                } catch (CookieCreateException ignore) {/*NOP*/}
                //делаем редирект на страцу товара, который добавляли в корзину
                response.sendRedirect(Statements.URI_PRODUCT + productID);
                return;
            } catch (NumberFormatException | NoSuchEntityException | DAOSystemException ex) {/*NOP*/}
        }
        response.sendRedirect(Statements.PAGE_ERROR);
    }
}
