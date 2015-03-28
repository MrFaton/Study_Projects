package net.Junior.Servlets.App07_eshop_V2.session.exceptions;

/**
 * Created by root on 28.03.2015.
 */
public class SessionException extends Exception {
    public SessionException() {
    }

    public SessionException(String message) {
        super(message);
    }

    public SessionException(Throwable cause) {
        super(cause);
    }
}
