package net.Junior.Servlets.App07_eshop_V2.session;

import net.Junior.Servlets.App07_eshop_V2.statements.Statements;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by root on 28.03.2015.
 */
public class Session_User {
    //наша сессия представаляет собой мапу
    private final Map<String, Object> session = new ConcurrentHashMap<>();
    //время, до какого момента живёт сессия, т.е. берётся текущее время + сколько заданно жить сессии
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

    public Iterator<String> getAllKeys() {
        return session.keySet().iterator();
    }

    //установить время жизни сессии
    public void setExpiration() {
        System.out.println("------> Session_User: setExpiration()");
        expiration = System.currentTimeMillis() + Statements.PARAM_SESSION_EXPIRATION;
    }

    //получить время жизни сессии
    public long getExpiration() {
        System.out.println("------> Session_User: getExpiration()");
        return expiration;
    }

}
/*
Конкретная сессия пользователя.
 */