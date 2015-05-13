package net.Junior.jdbc.pack00_mysql_simple;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Mr_Faton on 12.05.2015.
 */
public class App05_TooManyConnections {
    public static final String JDBC_URL =
            "jdbc:mysql://127.0.0.1:3306/my_test_db?user=Mr_Faton&password=123";//DB at my home
//    public static final String JDBC_URL =
//            "jdbc:mysql://192.168.101.1:3306/my_test_db?user=Mr_Faton&password=123";//DB at my work

    public static void main(String[] args) throws SQLException {
        Driver driver = new com.mysql.jdbc.Driver();
        open(driver, 1);
    }

    public static void open(Driver driver, int count) throws SQLException {
        System.err.println(count);
        /*
        рекурсия делается именно в трае с русурсами для того, чтобы когда мы достигнем предела соединений,
        то у нас вылетит исключение, и мы автоматически должны будем в каждом трае закрыть соединение,
        чтобы у БД не висели открытые соединения
         */
        try (Connection conn = driver.connect(JDBC_URL, new Properties())) {
            open(driver, count + 1);
        }
    }
}
