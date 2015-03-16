package net.Junior.Servlets.App03_eshop_V1.DAO.exceptions;

/**
 * Created by root on 16.03.2015.
 */
public class DaoSystemException extends DaoException {
    public DaoSystemException(String message) {
        super(message);
    }
    public DaoSystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
/*
Тут все системные исключения: потерялось соединение с БД, нет прав на доступ к БД
 */