package net.Junior.Servlets.WebApp_V3.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Created by root on 12.03.2015.
 */
public class MyServletRequestListener implements ServletRequestListener {
    public MyServletRequestListener() {
        System.out.println(">> MyServletRequestListener: I'm created");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println(">> MyServletRequestListener: request initialized (request in)");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println(">> MyServletRequestListener: request destroyed (request out)");
    }
}
/*
Дёргают методы, когда принят запрос и когда он обработан
 */