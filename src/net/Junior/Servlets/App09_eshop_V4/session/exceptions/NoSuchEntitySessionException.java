package net.Junior.Servlets.App09_eshop_V4.session.exceptions;

/**
 * Created by root on 28.03.2015.
 */
public class NoSuchEntitySessionException extends net.Junior.Servlets.App07_eshop_V2.session.exceptions.SessionBusinessException {
    public NoSuchEntitySessionException() {
    }

    public NoSuchEntitySessionException(String message) {
        super(message);
    }

    public NoSuchEntitySessionException(Throwable cause) {
        super(cause);
    }
}
