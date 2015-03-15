package net.Junior.Servlets.App02_WebApp_V3.listeners;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Created by root on 12.03.2015.
 */
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {
    public MyHttpSessionAttributeListener() {
        System.out.println(">> MyHttpSessionAttributeListener: I'm created");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println(">> MyHttpSessionAttributeListener: attribute added");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println(">> MyHttpSessionAttributeListener: attribute removed");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println(">> MyHttpSessionAttributeListener: attribute replaced");
    }
}
