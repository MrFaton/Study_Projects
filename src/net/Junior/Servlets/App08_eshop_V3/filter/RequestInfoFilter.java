package net.Junior.Servlets.App08_eshop_V3.filter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by root on 28.03.2015.
 */
public class RequestInfoFilter extends BaseFilter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("--> RequestInfoFilter: init");
    }

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println("\n--> RequestInfoFilter: RequestInfo --->");
        System.out.println("--> uri: " + request.getRequestURI());
        System.out.println("--> method: " + request.getMethod());
        System.out.println("--> protocol: " + request.getProtocol());
        System.out.println("--> client Ip: " + request.getRemoteAddr());
        System.out.println("--> RequestInfoFilter: RequestInfo <---\n");
        filterChain.doFilter(request, response);
    }
}
/*
doFilter - получается как-бы виртуальный вызов методов.
Сначала Томкат вызывает doFilter (ServletRequest, ServletResponse) у  RequestInfoFilter. Но тут такого метода нет.
Но если RequestInfoFilter является фильтром (а у Filter есть метод doFilter (ServletRequest, ServletResponse)), значит
у предка RequestInfoFilter есть метод doFilter (ServletRequest, ServletResponse). Подымается к BaseFilter. Да, там
есть такой метод, вызываем его. Но в теле метода doFilter (ServletRequest, ServletResponse) асбстрактного класса
BaseFilter есть вызов другого метода doFilter(HttpServletRequest , HttpServletResponse). Но у BaseFilter этот метод
абстрактный, значит его реализация есть его потомка, у RequestInfoFilter. Да и таки тут есть этот метод и вызывается он.

Фильтр отображает информацию о входящих заросах
 */