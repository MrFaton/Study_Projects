package net.Junior.Servlets.WebApp_V3.listeners;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/**
 * Created by root on 12.03.2015.
 */
public class MyServletRequestAttributeListener implements ServletRequestAttributeListener {
    public MyServletRequestAttributeListener() {
        System.out.println(">> MyServletRequestAttributeListener: I'm created");
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println(">> MyServletRequestAttributeListener: attribute added");
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println(">> MyServletRequestAttributeListener: attribute removed");
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println(">> MyServletRequestAttributeListener: attribute replaced");
    }
}
