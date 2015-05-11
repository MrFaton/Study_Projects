package net.Junior.jdbc.app00_mysql_simple;

import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Mr_Faton on 09.05.2015.
 */
public class App00 {
    public static final String JDBC_URL =
            "jdbc:mysql://127.0.0.1:3306/my_test_db?user=Mr_Faton&password=123";//DB at my home
//    public static final String JDBC_URL =
//            "jdbc:mysql://192.168.101.1:3306/my_test_db?user=Mr_Faton&password=123";//DB at my work

    public static void main(String[] args) throws SQLException {
        com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
        com.mysql.jdbc.JDBC4Connection connection =
                (com.mysql.jdbc.JDBC4Connection) driver.connect(JDBC_URL, new Properties());
        System.out.println("Наше соединение:\n" + connection);
        connection.close();
    }
}
