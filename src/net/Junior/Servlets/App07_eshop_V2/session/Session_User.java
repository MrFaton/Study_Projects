package net.Junior.Servlets.App07_eshop_V2.session;

import net.Junior.Servlets.App07_eshop_V2.statements.Statements;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by root on 28.03.2015.
 */
public class Session_User {
    private final Map<String, Object> session = new ConcurrentHashMap<>();
    private Long expiration;

    public Session_User() {
        setExpiration();
    }

    public Object put(String key, Object value) {
        Object oldValue = session.get(key);
        session.put(key, value);
        return oldValue;
    }

    public Object get(String key) {
        return session.get(key);
    }

    public Iterator<String> getAllKeys() {
        return session.keySet().iterator();
    }

    public void setExpiration() {
        System.out.println("------> Session_User 1setExpiration()");
        expiration = System.currentTimeMillis() + Statements.PARAM_SESSION_EXPIRATION;
        System.out.println("------> Session_User 2setExpiration()" + expiration);
    }

    public Long getExpiration() {
        System.out.println("------> Session_User getExpiration()");
        return expiration;
    }

}
