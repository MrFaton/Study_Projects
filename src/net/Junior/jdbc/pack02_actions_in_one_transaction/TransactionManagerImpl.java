package net.Junior.jdbc.pack02_actions_in_one_transaction;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.Callable;

/**
 * Created by Mr_Faton on 18.05.2015.
 */
public class TransactionManagerImpl extends BaseDataSource implements TransactionManager {
    public static final String JDBC_URL =
            "jdbc:mysql://127.0.0.1:3306/my_test_db?user=Mr_Faton&password=123";//DB at my home
    private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<>();

    @Override
    public <T> T doInTransaction(Callable<T> unitOfWork) throws Exception {
        Connection connection = DriverManager.getConnection(JDBC_URL);
        connection.setAutoCommit(false);
        connectionHolder.set(connection);
        try {
            T result = unitOfWork.call();
            connection.commit();
            return result;
        } catch (Exception ex) {
            connection.rollback();
            throw ex;
        } finally {
            connection.close();
            connectionHolder.remove();
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return connectionHolder.get();
    }
}
