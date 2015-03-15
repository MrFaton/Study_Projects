package net.Junior.Servlets.App02_WebApp_V3.listeners;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Created by root on 12.03.2015.
 */
public class MyHttpSessionBindingListener implements HttpSessionBindingListener {
    public MyHttpSessionBindingListener() {
        System.out.println(">> MyHttpSessionBindingListener: I'm created");
    }

    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println(">> MyHttpSessionBindingListener: value bound");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println(">> MyHttpSessionBindingListener: value unbound");
    }
}
/*
Когда штуковину ложат в сессию
 */