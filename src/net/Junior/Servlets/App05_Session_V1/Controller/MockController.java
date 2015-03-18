package net.Junior.Servlets.App05_Session_V1.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Mr_Faton on 18.03.2015.
 */
public class MockController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AtomicInteger counter;
        HttpSession session = request.getSession();
        counter = (AtomicInteger)session.getAttribute("counter");
        if (counter == null) {
            counter = new AtomicInteger(1);
            session.setAttribute("counter", counter);
        }
        int numOfVisits = counter.getAndIncrement();
        response.getWriter().write("You visit this page " + numOfVisits + " time.");
    }
}
