package net.Junior.Servlets.App03_eshop_V1.DAO.exceptions;

/**
 * Created by root on 16.03.2015.
 */
public class DaoBusinessException extends DaoException {
    public DaoBusinessException(String message) {
        super(message);
    }

    public DaoBusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
/*
все не системные исключения
 */