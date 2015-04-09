package net.Junior.Servlets.App09_eshop_V4.session;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by root on 28.03.2015.
 */
public class Session_User implements Serializable {
    private final Map<String, Object> session = new ConcurrentHashMap<>();

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
}
/*
Конкретная сессия пользователя.
 */