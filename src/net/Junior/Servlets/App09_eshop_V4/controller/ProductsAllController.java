package net.Junior.Servlets.App09_eshop_V4.controller;

import net.Junior.Servlets.App09_eshop_V4.dao.ProductDAO;
import net.Junior.Servlets.App09_eshop_V4.dao.exceptions.DAOSystemException;
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
 * Created by Mr_Faton on 27.03.2015.
 */
public class ProductsAllController extends HttpServlet {
    //как бы наша БД с продукутами
    private static final ProductDAO productDAO = new ProductDAOImpl();
    //объект этого касса позволяет нам работать с сессией клиента через его куки
    private SessionOnClientRepository sessionOnClientRepository = new SessionOnClientRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //получаем значение ид из запроса
        String requestedURI = request.getRequestURI();
        if (requestedURI.equals(Statements.URI_MAIN_1) || requestedURI.equals(Statements.URI_MAIN_2)) {
            //поисковик куки по её имени
            CookieFinder cookieFinder = new CookieFinder();
            try {
                //получаем куку клиента с его сессией
                Cookie sessionCookie = cookieFinder.findCookieByName(Statements.COOKIE_MY_SESSION, request);
                //если клиент передал такую куку
                if (sessionCookie != null) {
                    System.out.println("-----> User has got a session cookie");
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
                } else {
                    System.out.println("-----> User hasn't got a cookie, don't create session");
                }
                //ложим в атрибут запроса все продукты из БД
                request.setAttribute(Statements.ATTRIBUTE_PRODUCTS_LIST, productDAO.selectAll());
                //передаём управление на jsp
                request.getRequestDispatcher(Statements.PAGE_MAIN).forward(request, response);
                return;
            } catch (DAOSystemException ex) {/*NOP*/}
        }
        response.sendRedirect(Statements.PAGE_ERROR);
    }
}