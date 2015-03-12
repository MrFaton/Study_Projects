package net.Junior.Servlets.WebApp_V3.listeners;

import javax.servlet.*;

/**
 * Created by root on 12.03.2015.
 */
public class MyServletContextListener implements ServletContextListener {
    public MyServletContextListener() {
        System.out.println(">> MyServletContextListener: I'm created");
    }

    //вызывается когда Томкат поднял приложение
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println(">> MyServletContextListener: ServletContext created");
    }

    //вызывается когда Томкат убил приложение
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println(">> MyServletContextListener: ServletContext destroyed");
    }
}
