package net.Junior.Servlets.App07_eshop_V2.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by root on 28.03.2015.
 */
public abstract class BaseFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //NOP
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println("\n--> BaseFilter: start call method with ServletRequest and ServletResponse");
        doFilter((HttpServletRequest) servletRequest, (HttpServletResponse) servletResponse, filterChain);
        System.out.println("--> BaseFilter: end call method with ServletRequest and ServletResponse");
    }

    public abstract void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException;

    @Override
    public void destroy() {
        //NOP
    }
}
/*
основной фильтр, который реализует интерфейс Filter и создаёт ещё один метод doFilter, который преобразовывает
ServletRequest servletRequest, ServletResponse servletResponse в HttpServletRequest request, HttpServletResponse response
 */