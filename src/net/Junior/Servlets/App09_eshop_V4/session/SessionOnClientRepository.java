package net.Junior.Servlets.App09_eshop_V4.session;


import javax.servlet.http.Cookie;
import java.util.Base64;

/**
 * Created by root on 28.03.2015.
 */
public class SessionOnClientRepository {
    private static Base64.Decoder decoder = Base64.getDecoder();
    private static Base64.Encoder encoder = Base64.getEncoder();

    public Session_User getSessionByCookie(Cookie cookie) {
        System.out.println("------> SessionOnClientRepository: getSessionByCookie(Cookie cookie)");
        return getSessionByCookie(cookie, true);
    }

    public Session_User getSessionByCookie(Cookie cookie, boolean canCreate) {
        System.out.println("------> SessionOnClientRepository: getSessionById(Cookie cookie, boolean canCreate)");
        String serializableSession = cookie.getValue();
        byte[] sessionBytes = decoder.decode(serializableSession);
        String sessionString = new String(sessionBytes);

    }

    public String createSession() {
        System.out.println("------> SessionOnClientRepository: createSession()");

    }
}