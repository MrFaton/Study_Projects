package net.Junior.Servlets.WebApp_V3.filters;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by root on 12.03.2015.
 */
public class ProcessingTime_Filter extends BaseFilter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(">> ProcessingTime_Filter: I'm created");
    }

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        long workTime = System.currentTimeMillis();
        filterChain.doFilter(request, response);
        workTime = System.currentTimeMillis() - workTime;

        System.out.println(">> ProcessingTime_Filter: request is processing in " + workTime + " millis");
    }
}
/*
Если небыло бы BaseFilter, пришлось бы реализовавать все 3 метода интерфейса Filter
 */