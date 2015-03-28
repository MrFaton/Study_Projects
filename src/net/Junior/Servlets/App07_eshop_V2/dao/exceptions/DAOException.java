package net.Junior.Servlets.App07_eshop_V2.dao.exceptions;

/**
 * Created by Mr_Faton on 27.03.2015.
 */
public class DAOException extends Exception {

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOException(Throwable cause) {
        super(cause);
    }
}
