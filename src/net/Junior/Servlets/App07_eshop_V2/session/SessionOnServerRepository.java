package net.Junior.Servlets.App07_eshop_V2.session;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by root on 28.03.2015.
 */
public class SessionOnServerRepository {
    private final static Map<String, Session_User> sessions = new ConcurrentHashMap<>();
    public static Session_User getSessionById(String sessionID) {
        return getSessionById(sessionID, true);
    }

    public static Session_User getSessionById(String sessionID, boolean canCreate) {
        Session_User session_user = sessions.get(sessionID);
        if (session_user == null && canCreate) {
            session_user = new Session_User();
            sessions.put(sessionID, session_user);
        }
        return session_user;
    }
}
