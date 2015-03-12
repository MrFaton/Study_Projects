package net.Junior.Servlets.WebApp_V3.listeners;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * Created by root on 12.03.2015.
 */
public class MyHttpSessionActivationListener implements HttpSessionActivationListener {
    public MyHttpSessionActivationListener() {
        System.out.println(">> MyHttpSessionActivationListener: I'm created");
    }

    @Override
    public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {
        System.out.println(">> MyHttpSessionActivationListener: session will passivate");
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {
        System.out.println(">> MyHttpSessionActivationListener: session did activate");
    }
}
/*
Когда в сессию добавляют/удаляют аттрибуты
 */