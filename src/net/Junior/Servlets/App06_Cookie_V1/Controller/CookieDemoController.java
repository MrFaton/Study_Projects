package net.Junior.Servlets.App06_Cookie_V1.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by Mr_Faton on 18.03.2015.
 */
public class CookieDemoController extends HttpServlet{
    //кука-счётчик будет иметь такое название
    public static final String COOKIE_COUNTER = "counter";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //кука-счётчик от клиента
        Cookie cookieCounterFromClient = null;
        //список всех куков, которые прислал клиент
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            //если есть хоть какие-то куки, проходимся по списку и проверяем имя каждой куки
            for (Cookie cookie : cookies ) {
                //если есть кука с именем куки-счётчика
                if (COOKIE_COUNTER.equals(cookie.getName())) {
                    //присваиваем нашей куке-счётчике найденую куку в списке
                    cookieCounterFromClient = cookie;
                    break;
                }
            }
        }
        if (cookieCounterFromClient != null) {
            //если от клиента всё же была найдена кука-счётчик. Вытаскиваеи её значение
            int numOfVisits = Integer.valueOf(cookieCounterFromClient.getValue());
            //инкременируем значение и обновляем куку у клиента
            resp.addCookie(new Cookie(COOKIE_COUNTER, (++numOfVisits) + ""));
            //рендерим ответ клиенту и записываем ему новое значение куки-счётчика
            resp.getWriter().write("You visit this page " + numOfVisits + " times");
        } else {
            //если клиент у нас впервые (он нам не передал куку-счётчик). Создаём у него куку со значением 1
            resp.addCookie(new Cookie(COOKIE_COUNTER, "1"));
            //пишем ему ответ, что он у нас первый раз
            resp.getWriter().write("You visit this page 1 time");
        }
    }
}
