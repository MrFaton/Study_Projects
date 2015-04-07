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
    //как бы наша БД с продукутами
    private static final ProductDAO productDAO = new ProductDAOImpl();
    //хранилище сессий на сервере
    private static final SessionOnServerRepository sessionOnServerRepository = SessionOnServerRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestedURI = request.getRequestURI();
        if (requestedURI.equals(Statements.URI_MAIN_1) || requestedURI.equals(Statements.URI_MAIN_2)) {
            //класс, который ищек куку по её имени
            CookieFinder cookieFinder = new CookieFinder();
            try {
                //кука с ид сессии клиента
                Cookie jsessionid_cookie = cookieFinder.findCookieByName(Statements.COOKIE_JSESSIONID, request);
                //если у клиента есть кука, содержащия ид сессии
                if (jsessionid_cookie != null) {
                    //получаем ид сессии из куки
                    String sessionId = jsessionid_cookie.getValue();
                    System.out.println("-----> User has got a cookie: " + sessionId);
                    //пытаемся получить сессию клиента по ид из куки
                    Session_User session_user = sessionOnServerRepository.getSessionById(sessionId, false);
                    //если нам удалось получить сессию (т.е. сессия с таким ид есть на сервере)
                    if (session_user != null) {
                        //продлеваем жизнь сесси клиента на сервере
                        session_user.setExpiration();
                        //пытаемся получить корзину покупок клиента
                        Map<Product, Integer> basket =
                                (Map<Product, Integer>) session_user.get(Statements.ATTRIBUTE_BASKET);
                        //в независимости есть у клиента корзина или нет, ложим её в атрибут запроса (jsp знает что делать)
                        request.setAttribute(Statements.ATTRIBUTE_BASKET, basket);
                        //продлеваем жизнь куки на браузере у клиента
                        jsessionid_cookie.setMaxAge(Statements.COOKIE_LIFETIME);//время жизни в секундах
                        response.addCookie(jsessionid_cookie);
                    } else {
                        System.out.println("-----> But JSESSIONID doesn't find on server " + sessionId);
                    }
                } else {
                    System.out.println("-----> User hasn't got a cookie, don't create session");
                }

                //просто выводим список всех сессий, которые есть на сервере
                System.out.println("\n+++++> Sessions List");
                for (Map.Entry<String, Session_User> element : sessionOnServerRepository.getSessionsMap().entrySet()) {
                    System.out.println(element.getKey());
                }
                System.out.println("+++++> End of Sessions List\n");

                //добавляем в атрибут запроса список всех продуктов, которые есть в БД
                request.setAttribute(Statements.ATTRIBUTE_PRODUCTS_LIST, productDAO.selectAll());
                //передаём запрос на jsp
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
Интересной особенностью класса, явлеяется то, что он получив запрос, пытается получить сессию клиента по её ид и
вытащить от туда корзину клиента с покупками. Если ему это удаётся, он ложит корзину (а корзина - это мапа
Product на Integer) в атрибут запроса, далее передаёт запрос на jsp, она пытается получить корзину пользователя,
если ей это удаётся, то она отображает корзину покупок.
 */