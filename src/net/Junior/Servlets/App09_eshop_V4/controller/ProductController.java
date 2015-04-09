package net.Junior.Servlets.App09_eshop_V4.controller;

import net.Junior.Servlets.App09_eshop_V4.dao.ProductDAO;
import net.Junior.Servlets.App09_eshop_V4.dao.exceptions.DAOSystemException;
import net.Junior.Servlets.App09_eshop_V4.dao.exceptions.NoSuchEntityException;
import net.Junior.Servlets.App09_eshop_V4.dao.implementation.ProductDAOImpl;
import net.Junior.Servlets.App09_eshop_V4.entity.CookieFinder;
import net.Junior.Servlets.App09_eshop_V4.entity.Product;
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
* Created by Mr_Faton on 05.04.2015.
*/
public class ProductController extends HttpServlet {
    //как бы наша БД с продукутами
    private ProductDAO productDAO = new ProductDAOImpl();
    //объект этого касса позволяет нам работать с сессией клиента через его куки
    private SessionOnClientRepository sessionOnClientRepository = new SessionOnClientRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //получаем значение ид из запроса
        String idStr = request.getParameter(Statements.PARAM_ID);
        //если значение существует
        if (idStr != null) {
            try {
                //пытаемся получить значение ид в виде int из String
                int id = Integer.valueOf(idStr);
                //получаем продукт по этому ид из БД
                Product product = productDAO.selectById(id);

                //поисковик куки по имени
                CookieFinder cookieFinder = new CookieFinder();
                //получаем куку клиента с его сессией
                Cookie sessionCookie = cookieFinder.findCookieByName(Statements.COOKIE_MY_SESSION, request);
                //если клиент передал такую куку
                if (sessionCookie != null) {
                    try {
                        //пытаемся получить его сессию из его куки, но в случае не удачи не создаём новую сессию
                        Session_User session_user = sessionOnClientRepository.getSessionByCookie(sessionCookie, false);
                        //вытаскиваем корзину с покупками
                        Map<Product, Integer> basket =
                                (Map<Product, Integer>) session_user.get(Statements.ATTRIBUTE_BASKET);
                        //ложим корзину в атрибут запроса
                        request.setAttribute(Statements.ATTRIBUTE_BASKET, basket);
                        //продлеваем жизнь куки
                        sessionCookie.setMaxAge(Statements.COOKIE_LIFETIME);//время жизни в секундах
                        //добавляем куку к ответу
                        response.addCookie(sessionCookie);
                    } catch (NoSuchSessionException ignore) {/*NOP*/}
                }

                //ложим в атрибут запроса сам продукт
                request.setAttribute(Statements.ATTRIBUTE_PRODUCT_TO_VIEW, product);
                //передаём управление на jsp
                request.getRequestDispatcher(Statements.PAGE_PRODUCT).forward(request, response);
                return;

            } catch (NumberFormatException | NoSuchEntityException | DAOSystemException ex) {/*NOP*/}
        }
        response.sendRedirect(Statements.PAGE_ERROR);
    }
}
