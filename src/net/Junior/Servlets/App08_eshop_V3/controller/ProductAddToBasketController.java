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
    //как бы наша БД с продукутами
    private ProductDAO productDAO = new ProductDAOImpl();
    //хранилище сессий на сервере
    private static final SessionOnServerRepository sessionOnServerRepository = SessionOnServerRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //получаем значение ид продукта из запроса
        String productIDStr = request.getParameter(Statements.PARAM_ID);
        //сессия клиента
        Session_User session_user;
        //строкове ид сессии клиента
        String sessionId;
        //если в запросе был параметр ид
        if (productIDStr != null) {
            try {
                //пытаемся получить значение ид в виде int из String
                int productID = Integer.valueOf(productIDStr);
                //получаем продукт по этому ид из БД
                Product product = productDAO.selectById(Integer.valueOf(productID));

                //получаем сессию клиента

                //класс, который ищек куку по её имени
                CookieFinder cookieFinder = new CookieFinder();
                //кука с ид сессии клиента
                Cookie jsessionid_cookie = cookieFinder.findCookieByName(Statements.COOKIE_JSESSIONID, request);

                //если у клиента есть кука с ид сессией
                if (jsessionid_cookie != null) {
                    //получаем ид сессии из куки
                    sessionId = jsessionid_cookie.getValue();
                } else {
                    //значит у клиента нет куки с ид сессии
                    //создаём сессию в хранилище сессий на сервере
                    sessionId = sessionOnServerRepository.createSession();
                    //создаём куку для пользователя и даём её ид сессии клиента
                    jsessionid_cookie = new Cookie(Statements.COOKIE_JSESSIONID, sessionId);
                }

                //получаем сессию клиента по её ид из хранилища сессий на сервере
                session_user = sessionOnServerRepository.getSessionById(sessionId);
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
                //продлеваем жизнь сессии пользователя на сервере
                session_user.setExpiration();

                //продлеваем жизнь куки на браузере
                jsessionid_cookie.setMaxAge(Statements.COOKIE_LIFETIME);//время жизни в секундах
                //добавляем куку к ответу
                response.addCookie(jsessionid_cookie);
                //обязательно делаем редирект, для того чтобы в браузере сменился ЮРЛ и клиент думал, что он оставался на страинце с продуктом, который он добалял в корзину
                response.sendRedirect(Statements.URI_PRODUCT + productID);
                return;
            } catch (NumberFormatException | NoSuchEntityException | DAOSystemException ex) {/*NOP*/}
        }
        response.sendRedirect(Statements.PAGE_ERROR);
    }
}
/*
Как работает объект этого класса
Этот класс добавляет определённый тип продукта в корзину (Хлеб, Масло, Сыр).
JSP строит ссылки типа "/productAddToBasket.do?id=1" (1 - если на странице хлеба).
Когда мы в браузере клацаем по этой ссылке, мы попадаем на этот сервлет. ЮРЛ в браузере меняется на ЮРЛ ссылки.
Этот сервет пытается получить ид сессии из куки, если куки нет или нет сессии на сервере с таким ид, то он
создаёт сессию в хранилище, затем получает доступ к этой сессии клинета по её ид. Вытягивает от туда корзину
покупок пользователя (если её нет, то создаёт) добавляет в корзину на одни продукт больше, ложит в корзину,
корзину в сессию. И делает Редирект на страницу с продуктом "/product.do?id=1". ЮРЛ снова меняется.
Смена ЮРЛов происходит так быстро, что кажется что мы оставались на стринице с продуктом.
 */