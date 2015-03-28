package net.Junior.Servlets.App07_eshop_V2.session;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by root on 28.03.2015.
 */
public class Session_User {
    private final Map<String, Object> session = new ConcurrentHashMap<>();

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
}
