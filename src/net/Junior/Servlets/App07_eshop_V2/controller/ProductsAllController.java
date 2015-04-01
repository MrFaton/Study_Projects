package net.Junior.Servlets.App07_eshop_V2.controller;

import net.Junior.Servlets.App07_eshop_V2.dao.ProductDAO;
import net.Junior.Servlets.App07_eshop_V2.dao.exceptions.DAOSystemException;
import net.Junior.Servlets.App07_eshop_V2.dao.implementation.ProductDAOImpl;
import net.Junior.Servlets.App07_eshop_V2.entity.CookieFinder;
import net.Junior.Servlets.App07_eshop_V2.session.SessionOnServerRepository;
import net.Junior.Servlets.App07_eshop_V2.session.Session_User;
import net.Junior.Servlets.App07_eshop_V2.statements.Statements;

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
    //как-бы база данных
    private final ProductDAO productDAO = new ProductDAOImpl();
    //хранилище сессий на нашем сервере
    private static final SessionOnServerRepository sessionOnServerRepository = SessionOnServerRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestedURI = request.getRequestURI();
        //Если ЮРИ равен "/productsAll.do" или "/"
        if (requestedURI.equals(Statements.URI_MAIN_1) || requestedURI.equals(Statements.URI_MAIN_2)) {
            //класс-поисковик куков среди переданных куков от клиента
            CookieFinder cookieFinder = new CookieFinder();
            try {
                //ищем куку у клиента, которая содержит ид сессии на сервере, а именно куку с именем "MY_JSESSIONID"
                Cookie jsessionid_cookie = cookieFinder.findCookieByName(Statements.COOKIE_JSESSIONID, request);
                if (jsessionid_cookie != null) {
                    //мы нашли такую куку у клиента и вытягиваем из неё ид сессии
                    String sessionId = jsessionid_cookie.getValue();
                    System.out.println("-----> User has got a cookie: " + sessionId);
                    //пытаемся получить сессию юзера (фактически это мапа) по ид сессии, полученного от клиента, но если это неудастся, то новой сессии не создаём
                    Session_User session_user = sessionOnServerRepository.getSessionById(sessionId, false);
                    //если на сервере есть сессия с таким ид, продлеваем время жизни сессии
                    if (session_user != null) {
                        session_user.setExpiration();
                    } else {
                        //клиент передал ид сессии, которого нет на сервере (возможно такая сессия была удалена очистителем)
                        System.out.println("-----> But JSESSIONID doesn't find on server " + sessionId);
                    }
                } else {
                    //клиент не передал нам куки, содержащей ид сессии
                    System.out.println("-----> User hasn't got a cookie, try to create it");
                    //создаём сессию для клиента
                    String sessionId = sessionOnServerRepository.createSession();
                    System.out.println("----> " + sessionId);
                    System.out.println("----> creating finish");
                    //создаём новую куку, которая содержит ид сессии данного клиента
                    jsessionid_cookie = new Cookie(Statements.COOKIE_JSESSIONID, sessionId);
//                    jsessionid_cookie.setComment("Кука для доступа к сесси на сервере"); //почему-то выдаёт ошибку
                }
                //устанавливаем время жизни куки (или продлеваем время жизни, если она уже была у клиента)
                jsessionid_cookie.setMaxAge(10 * 60);//время жизни в секундах, мне нужно чтобы кука жила 10 минут в браузере
                //добавляем куку клиенту
                response.addCookie(jsessionid_cookie);

                //распечатать список сесский, которые есть на сервере
                System.out.println("+++++> Sessions List");
                for (Map.Entry<String, Session_User> element : sessionOnServerRepository.getSessionsMap().entrySet()) {
                    System.out.println(element.getKey());
                }
                System.out.println("+++++> End of Sessions List");

                //установить атрибут с именем "productsList", содержащим список всех продуктов из БД, в запрос от клиента
                request.setAttribute(Statements.ATTRIBUTE_PRODUCTS_LIST, productDAO.selectAll());
                //передать управление на jsp
                request.getRequestDispatcher(Statements.PAGE_MAIN).forward(request, response);
                return;
            } catch (DAOSystemException exception) {
                System.err.println("Проблемы с БД");
            }
        }
        //если произошли какие-то ошибки, выбросить клиента на страницу с ошибками
        response.sendRedirect(Statements.PAGE_ERROR);
    }
}
/*
Основной контроллер
jsessionid_cookie.setMaxAge(int x);, тут х - время жизни куки на браузере в секундах
 */