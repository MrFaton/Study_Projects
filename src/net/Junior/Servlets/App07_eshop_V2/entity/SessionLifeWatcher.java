package net.Junior.Servlets.App07_eshop_V2.entity;

import net.Junior.Servlets.App07_eshop_V2.session.SessionOnServerRepository;
import net.Junior.Servlets.App07_eshop_V2.session.Session_User;

import java.util.Map;

/**
 * Created by Mr_Faton on 31.03.2015.
 */
public class SessionLifeWatcher {
    private static SessionLifeWatcher sessionLifeWatcher = null;
    private static SessionOnServerRepository sessionOnServerRepository = SessionOnServerRepository.getInstance();


    private SessionLifeWatcher() {
    }

    public static synchronized SessionLifeWatcher getInstance() {
        System.out.println("------> SessionLifeWatcher getInstance()");
        if (sessionLifeWatcher == null) {
            sessionLifeWatcher = new SessionLifeWatcher();
        }
        return sessionLifeWatcher;
    }

    public static synchronized void removeSession(String sessionId) throws IllegalArgumentException {
        System.out.println("------> SessionLifeWatcher 1removeSession()");
        if (sessionId == null || sessionId.length() == 0) {
            throw new IllegalArgumentException("bad sessionId");
        }
        System.out.println("------> SessionLifeWatcher 2removeSession()");
        sessionOnServerRepository.removeSession(sessionId);
    }

    public static synchronized Long checkAndRemoveSession() {
        System.out.println("------> SessionLifeWatcher checkAndRemoveSession()");
        Map<String, Session_User> sessionsMap = sessionOnServerRepository.getSessionsMap();
        Long minSessionExpiration = Long.MAX_VALUE;
        String sessionId = "";
        for (Map.Entry<String, Session_User> element : sessionsMap.entrySet()) {
            if (minSessionExpiration > element.getValue().getExpiration()) {
                minSessionExpiration = element.getValue().getExpiration();
                sessionId = element.getKey();
            }
        }
        if ((minSessionExpiration - System.currentTimeMillis()) <= 1000) {
            sessionOnServerRepository.removeSession(sessionId);
        }
        return minSessionExpiration;
    }
}
