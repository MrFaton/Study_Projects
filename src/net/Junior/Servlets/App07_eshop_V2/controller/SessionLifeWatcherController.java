package net.Junior.Servlets.App07_eshop_V2.controller;

import net.Junior.Servlets.App07_eshop_V2.entity.SessionLifeWatcherThread;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mr_Faton on 31.03.2015.
 */
public class SessionLifeWatcherController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Thread sessionLifeWatcherThread = new Thread(new SessionLifeWatcherThread());
        sessionLifeWatcherThread.setDaemon(true);
        sessionLifeWatcherThread.start();
        response.getWriter().write("SessionLifeWatcher is Enable");
    }
}
