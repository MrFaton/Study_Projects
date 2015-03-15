package net.Junior.Servlets.App01_WebApp_V2.filters;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mr_Faton on 11.03.2015.
 */
public class RequestInfo_Filter extends BaseFilter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(">> RequestInfo_Filter: init");
    }

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String method = request.getMethod();
        String requestURI = request.getRequestURI();
        String protocol = request.getProtocol();
        String localAddr = request.getLocalAddr();

        System.out.println(">> RequestInfo_Filter: units>>>>");
        System.out.println("" +
                ">>>> method = " + method + "\n" +
                ">>>> requestURI = " + requestURI + "\n" +
                ">>>> protocol = " + protocol + "\n" +
                ">>>> localAddr = " + localAddr);
        System.out.println(">> RequestInfo_Filter: units<<<<");
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println(">> RequestInfo_Filter: destroyed");
    }
}
