package net.Junior.Servlets.App09_eshop_V4.session.exceptions;

/**
 * Created by root on 28.03.2015.
 */
public class SessionBusinessException extends net.Junior.Servlets.App07_eshop_V2.session.exceptions.SessionException {
    public SessionBusinessException() {
    }

    public SessionBusinessException(String message) {
        super(message);
    }

    public SessionBusinessException(Throwable cause) {
        super(cause);
    }
}
