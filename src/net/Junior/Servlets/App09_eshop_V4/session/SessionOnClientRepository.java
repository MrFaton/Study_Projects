package net.Junior.Servlets.App09_eshop_V4.session;


import net.Junior.Servlets.App09_eshop_V4.statements.Statements;

import javax.servlet.http.Cookie;
import java.io.*;
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
        System.out.println("------> SessionOnClientRepository: getSessionByCookie(Cookie cookie, boolean canCreate)");
        String encodedSerializableSession = cookie.getValue();
        if (encodedSerializableSession != null) {
            byte[] sessionBytes = decoder.decode(encodedSerializableSession);
            try (ByteArrayInputStream in = new ByteArrayInputStream(sessionBytes);
                 ObjectInputStream objectInput = new ObjectInputStream(in)) {
                Session_User session_user = (Session_User) objectInput.readObject();
                return session_user;
            } catch (IOException | ClassNotFoundException | ClassCastException ex) {/*NOP*/}
        }
        return null;
    }

    public Cookie createSessionCookie(Session_User session_user) {
        System.out.println("------> SessionOnClientRepository: createSession()");
        if (session_user != null) {
            Cookie userSessionCookie;
            try (ByteArrayOutputStream out = new ByteArrayOutputStream();
                 ObjectOutputStream objectOutput = new ObjectOutputStream(out)) {
                objectOutput.writeObject(session_user);
                objectOutput.flush();
                byte[] sessionBytes = out.toByteArray();
                String encodedSerializableSession = encoder.encodeToString(sessionBytes);
                userSessionCookie = new Cookie(Statements.COOKIE_MY_SESSION, encodedSerializableSession);
                return userSessionCookie;
            } catch (IOException ex) {/*NOP*/}
        }
        return null;
    }
}