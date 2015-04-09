package net.Junior.Servlets.App09_eshop_V4.entity.cookie.exceptions;

/**
 * Created by root on 09.04.2015.
 */
public class CookieException extends Exception {
    public CookieException() {
    }

    public CookieException(String message) {
        super(message);
    }

    public CookieException(String message, Throwable cause) {
        super(message, cause);
    }

    public CookieException(Throwable cause) {
        super(cause);
    }
}
