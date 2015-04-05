package net.Junior.Servlets.App08_eshop_V3.dao.exceptions;

/**
 * Created by Mr_Faton on 27.03.2015.
 */
public class NoSuchEntityException extends DAOBusinessException {
    public NoSuchEntityException(String message) {
        super(message);
    }

    public NoSuchEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchEntityException(Throwable cause) {
        super(cause);
    }
}
