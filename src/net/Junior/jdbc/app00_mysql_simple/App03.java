package net.Junior.jdbc.app00_mysql_simple;

import net.Junior.jdbc.app00_mysql_simple.my_driver.SuperDB_Driver0;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

/**
 * Created by Mr_Faton on 09.05.2015.
 */
public class App03 {
    public static final String JDBC_URL =
            "jdbc:mysql://127.0.0.1:3306/my_test_db?user=Mr_Faton&password=123";

    public static void main(String[] args) throws SQLException {
        //регистрируем наш новый драйвер
        DriverManager.registerDriver(new SuperDB_Driver0());

        Enumeration<Driver> iter = DriverManager.getDrivers();
        while (iter.hasMoreElements()) {
            Driver driver = iter.nextElement();
            System.out.println("driver = " + driver);
        }

        try (Connection connection = DriverManager.getConnection(JDBC_URL)) {
            System.err.println("Класс драйвера нашего соединения:\n" + connection.getClass());
        }

        try (Connection connection = DriverManager.getConnection("jdbc:SUPER_BD://")) {
            System.err.println("Класс драйвера нашего соединения:\n" + connection.getClass());
        }
    }
}