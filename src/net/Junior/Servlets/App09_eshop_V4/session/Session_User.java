package net.Junior.Servlets.App09_eshop_V4.session;

import net.Junior.Servlets.App09_eshop_V4.entity.Product;
import net.Junior.Servlets.App09_eshop_V4.statements.Statements;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by root on 28.03.2015.
 */
public class Session_User implements Serializable {
    private final Map<String, Object> session = new ConcurrentHashMap<>();
    private Map<Product, Integer> basket;
    private long expiration;

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

    public Object remove(String key) {
        Object oldValue = session.get(key);
        session.remove(key);
        return oldValue;
    }

    public void setExpiration() {
        System.out.println("------> Session_User: setExpiration()");
        expiration = System.currentTimeMillis() + Statements.PARAM_SESSION_EXPIRATION;
    }

    public long getExpiration() {
        System.out.println("------> Session_User: getExpiration()");
        return expiration;
    }

}
/*
Конкретная сессия пользователя.
 */