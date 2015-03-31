package net.Junior.Servlets.App07_eshop_V2.session;


import net.Junior.Servlets.App07_eshop_V2.entity.JSessionIdCreator;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by root on 28.03.2015.
 */
public class SessionOnServerRepository {
    private final static Map<String, Session_User> sessions = new ConcurrentHashMap<>();
    private final static JSessionIdCreator jSessionIdCreator = new JSessionIdCreator();
    private static SessionOnServerRepository sessionOnServerRepository = null;

    private SessionOnServerRepository() {
    }

    public static synchronized SessionOnServerRepository getInstance() {
        System.out.println("------> SessionOnServerRepository getInstance()");
        if (sessionOnServerRepository == null) {
            sessionOnServerRepository = new SessionOnServerRepository();
        }
        return sessionOnServerRepository;
    }

    public static Session_User getSessionById(String sessionID) {
        System.out.println("------> SessionOnServerRepository getSessionById(String sessionID)");
        return getSessionById(sessionID, true);
    }

    public static Session_User getSessionById(String sessionID, boolean canCreate) {
        System.out.println("------> SessionOnServerRepository getSessionById(String sessionID, boolean canCreate)");
        Session_User session_user = sessions.get(sessionID);
        if (session_user == null && canCreate) {
            session_user = new Session_User();
            sessions.put(sessionID, session_user);
        }
        return session_user;
    }

    public static synchronized String createSession() {
        System.out.println("------> SessionOnServerRepository createSession()");
        String sessionId;
        do {
            sessionId = jSessionIdCreator.generateID();
        } while (sessions.containsKey(sessionId));
        Session_User session_user = new Session_User();
        sessions.put(sessionId, session_user);
        return sessionId;
    }

    public static Map<String, Session_User> getSessionsMap() {
        System.out.println("------> SessionOnServerRepository getSessionsMap()");
        return Collections.unmodifiableMap(sessions);
    }

    public static synchronized void removeSession(String sessionId) {
        System.out.println("------> SessionOnServerRepository removeSession()");
        if (sessionId == null || sessionId.length() == 0) {
            throw new IllegalArgumentException("bad stringId");
        }
        sessions.remove(sessionId);
    }
}