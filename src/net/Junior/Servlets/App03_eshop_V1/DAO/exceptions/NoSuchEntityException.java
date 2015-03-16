package net.Junior.Servlets.App03_eshop_V1.DAO.exceptions;

/**
 * Created by root on 16.03.2015.
 */
public class NoSuchEntityException extends DaoBusinessException {
    public NoSuchEntityException(String message) {
        super(message);
    }

    public NoSuchEntityException(String message, Throwable cause) {
        super(message, cause);
    }
}
/*
вылетает, если ключа в БД нет
 */