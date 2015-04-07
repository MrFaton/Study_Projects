package net.Junior.Servlets.App09_eshop_V4.dao.exceptions;

/**
 * Created by Mr_Faton on 27.03.2015.
 */
public class DAOBusinessException extends DAOException {
    public DAOBusinessException(String message) {
        super(message);
    }

    public DAOBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOBusinessException(Throwable cause) {
        super(cause);
    }
}
