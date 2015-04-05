package net.Junior.Servlets.App08_eshop_V3.dao.exceptions;

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
/*
исключения, которые возможно выбрасывает наша база данных
 */