package net.Junior.Servlets.App02_WebApp_V3.listeners;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * Created by root on 12.03.2015.
 */
public class MyServletContextAttributeListener implements ServletContextAttributeListener {
    public MyServletContextAttributeListener() {
        System.out.println(">> MyServletContextAttributeListener: I'm created");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println(">> MyServletContextAttributeListener: attribute added");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println(">> MyServletContextAttributeListener: attribute removed");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println(">> MyServletContextAttributeListener: attribute replaced");
    }
}
/*
У контекста тоже есть атрибуты. У этого каласса вызываются методы, когд в ServletContext добавляют/удаляют/заменяют
атрибуты
 */