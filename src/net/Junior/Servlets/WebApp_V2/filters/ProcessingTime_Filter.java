package net.Junior.Servlets.WebApp_V2.filters;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mr_Faton on 11.03.2015.
 */
public class ProcessingTime_Filter extends BaseFilter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(">> ProcessingTime_Filter: init");

        System.out.println(">>>> Init params ----->");
        System.out.println(">>>>>> value of param_A: " + filterConfig.getInitParameter("param_A"));
        System.out.println(">>>>>> value of param_B: " + filterConfig.getInitParameter("param_B"));
        System.out.println(">>>> Init params <-----");
    }
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        long workTime = System.nanoTime();
        filterChain.doFilter(request, response);
        System.out.println(">>>> ProcessingTime_Filter: Time of ProcessingTime_Filter working is " + (System.nanoTime() - workTime) + "nanoSec");
    }

    @Override
    public void destroy() {
        System.out.println(">> ProcessingTime_Filter: destroyed");
    }
}
