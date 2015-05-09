package net.Junior.jdbc.app00_mysql_simple;

import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Mr_Faton on 09.05.2015.
 */
public class App01 {
    public static final String JDBC_URL =
            "jdbc:mysql://127.0.0.1:3306/my_test_db?user=Mr_Faton&password=123";

    public static void main(String[] args) throws SQLException {
        java.sql.Driver driver = new com.mysql.jdbc.Driver();

        //проверяет ЮРЛ на валидность. Проверяется только формат, есть ли кто живой на ИП - не проверяется
        System.out.println("JDBC_URL is good = " + driver.acceptsURL(JDBC_URL));
        System.out.println("Some URL is good = " + driver.acceptsURL("jdbc:SUPER_BD"));

        try (java.sql.Connection connection = driver.connect(JDBC_URL, new Properties())) {
            System.out.println("Наше соединение:\n" + connection);
        }
    }
}
