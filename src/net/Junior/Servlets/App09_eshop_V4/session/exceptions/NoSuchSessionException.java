package net.Junior.Servlets.App09_eshop_V4.session.exceptions;

/**
 * Created by root on 28.03.2015.
 */
public class NoSuchSessionException extends SessionBusinessException {
    public NoSuchSessionException() {
    }

    public NoSuchSessionException(String message) {
        super(message);
    }

    public NoSuchSessionException(Throwable cause) {
        super(cause);
    }
}
