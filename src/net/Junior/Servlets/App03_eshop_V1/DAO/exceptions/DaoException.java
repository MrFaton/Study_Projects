package net.Junior.Servlets.App03_eshop_V1.DAO.exceptions;

/**
 * Created by root on 16.03.2015.
 */
public class DaoException extends Exception {
    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
/*
все исключения, связанные с data access object
 */
