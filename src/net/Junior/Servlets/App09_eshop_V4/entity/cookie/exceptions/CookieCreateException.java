package net.Junior.Servlets.App09_eshop_V4.entity.cookie.exceptions;

/**
 * Created by root on 09.04.2015.
 */
public class CookieCreateException extends CookieException {
    public CookieCreateException() {
    }

    public CookieCreateException(String message) {
        super(message);
    }

    public CookieCreateException(String message, Throwable cause) {
        super(message, cause);
    }

    public CookieCreateException(Throwable cause) {
        super(cause);
    }
}
