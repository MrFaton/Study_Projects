package net.Junior.Servlets.App02_WebApp_V3.filters;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by root on 12.03.2015.
 */
public class RequestInfo_Filter extends BaseFilter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(">> RequestInfo_Filter: I'm created");
    }

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println(">> RequestInfo_Filter: request Info: \n" +
                "        method: " + request.getMethod() + "\n" +
                "        requestURI: " + request.getRequestURI() + "\n" +
                "        characterEncoding: " + request.getCharacterEncoding());
        filterChain.doFilter(request, response);
    }
}
