package net.Junior.Servlets.App08_eshop_V3.session.exceptions;

import net.Junior.Servlets.App07_eshop_V2.session.exceptions.*;

/**
 * Created by root on 28.03.2015.
 */
public class SessionSystemException extends SessionException {
    public SessionSystemException() {
    }

    public SessionSystemException(String message) {
        super(message);
    }

    public SessionSystemException(Throwable cause) {
        super(cause);
    }
}
