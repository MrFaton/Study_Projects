package net.Junior.jdbc.pack02_actions_in_one_transaction;

import java.util.concurrent.Callable;

/**
 * Created by Mr_Faton on 18.05.2015.
 */
public interface TransactionManager {
    public <T> T doInTransaction(Callable<T> unitOfWork) throws Exception;
}
