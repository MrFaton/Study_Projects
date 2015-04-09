package net.Junior.Servlets.App09_eshop_V4.session;


import net.Junior.Servlets.App09_eshop_V4.entity.cookie.exceptions.CookieCreateException;
import net.Junior.Servlets.App09_eshop_V4.session.exceptions.NoSuchSessionException;
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

    /*
    даём методу куку, которая должна содержать сессию. Назад получаем в любом случае сессию клиента. Если смогли получить
    сессию из его куки - возвращаем её, если нет, то создаём клиенту новую сессию
     */
    public Session_User getSessionByCookie(Cookie cookie) throws NoSuchSessionException {
        System.out.println("------> SessionOnClientRepository: getSessionByCookie(Cookie cookie)");
        return getSessionByCookie(cookie, true);
    }

    /*
    возвращает сессию клиента из его куки или кидает эксепшн, если восстановление не удалось - это происходит в случае
    если canCreate = false. Если canCreate = true, опять таки пробуем восстановить сессию клиента из его куки, но в
    случае неудачи мы создаём ему новую сессию
     */
    public Session_User getSessionByCookie(Cookie cookie, boolean canCreate) throws NoSuchSessionException {
        System.out.println("------> SessionOnClientRepository: getSessionByCookie(Cookie cookie, boolean canCreate)");
        //сессия клиента
        Session_User session_user;
        //получаем значение куки - это сериализированная сесси, превращённая в строку и закодированая Base64
        String encodedSerializableSession = cookie.getValue();
        //если у куки есть такая строка
        if (encodedSerializableSession != null) {
            //раскодируем по Base64 данные из куки и получаем сериализированный объект типа Session_User
            byte[] sessionBytes = decoder.decode(encodedSerializableSession);
            //пытаемся десериализировать объект Session_User, т.е. восстанавливаем Session_User
            try (ByteArrayInputStream in = new ByteArrayInputStream(sessionBytes);
                 ObjectInputStream objectInput = new ObjectInputStream(in)) {
                session_user = (Session_User) objectInput.readObject();
                return session_user;
            } catch (IOException | ClassNotFoundException | ClassCastException ex) {
                //при неудачном восстановлении и canCreate = true, создаём новую сессию для клиента
                if (canCreate) {
                    session_user = new Session_User();
                    return session_user;
                }
            }
        }
        throw new NoSuchSessionException();
    }

    /*
    даёшь сессию клинта, получаешь куку, в которую упакована сессия клиента
     */
    public Cookie createSessionCookie(Session_User session_user) throws CookieCreateException {
        System.out.println("------> SessionOnClientRepository: createSession()");
        //если сессия есть
        if (session_user != null) {
            //кука для клиента
            Cookie userSessionCookie;
            //пытаемся сериализовать сессию клиента
            try (ByteArrayOutputStream out = new ByteArrayOutputStream();
                 ObjectOutputStream objectOutput = new ObjectOutputStream(out)) {
                objectOutput.writeObject(session_user);
                objectOutput.flush();
                //получаем байтовый массив сериализованной сессии
                byte[] sessionBytes = out.toByteArray();
                //кодируем по Base64 байтовый массив с сессией в строку
                String encodedSerializableSession = encoder.encodeToString(sessionBytes);
                //создаём новую куку и ложим туда сессию-строку
                userSessionCookie = new Cookie(Statements.COOKIE_MY_SESSION, encodedSerializableSession);
                return userSessionCookie;
            } catch (IOException ignore) {
                /*NOP*/
                ignore.printStackTrace();
            }
        }
        throw new CookieCreateException();
    }
}
/*
Этот класс помогает нам работать с сессией клинета, которая храниться в его куках
 */