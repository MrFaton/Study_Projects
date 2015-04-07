package net.Junior.Servlets.App09_eshop_V4.entity;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Mr_Faton on 30.03.2015.
 */
public class CookieFinder {
    //передаём имя куки и запрос от пользователя, ищем куку по имени и возвращаем её, если такой нет, то возвращаем null
    public synchronized Cookie findCookieByName(String cookieName, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookieName.equals(cookie.getName())) {
                return cookie;
            }
        }
        return null;
    }
}