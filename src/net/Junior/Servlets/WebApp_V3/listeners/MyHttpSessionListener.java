package net.Junior.Servlets.WebApp_V3.listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by root on 12.03.2015.
 */
public class MyHttpSessionListener implements HttpSessionListener {
    public MyHttpSessionListener() {
        System.out.println(">> MyHttpSessionListener: I'm created");
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println(">> MyHttpSessionListener: session created");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println(">> MyHttpSessionListener: session destroyed");
    }
}
/*
Методы вызываются когда создаётся/удаляется Http сессия
 */