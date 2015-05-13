package net.Junior.jdbc.pack00_mysql_simple;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

/**
 * Created by Mr_Faton on 09.05.2015.
 */
public class App02 {
    public static final String JDBC_URL =
            "jdbc:mysql://127.0.0.1:3306/my_test_db?user=Mr_Faton&password=123";

    public static void main(String[] args) throws SQLException {
        Enumeration<Driver> iter = DriverManager.getDrivers();
        while (iter.hasMoreElements()) {
            Driver driver = iter.nextElement();
            System.out.println("driver = " + driver);
        }

        try (Connection connection = DriverManager.getConnection(JDBC_URL)) {
            System.out.println("Наше соединение:\n" + connection);
        }

        try (Connection connection = DriverManager.getConnection("jdbc:SUPER_BD")) {
            System.out.println("Наше соединение:\n" + connection);
        }
    }
}
/*
Результат
driver = com.mysql.jdbc.Driver@28a418fc
driver = com.mysql.fabric.jdbc.FabricMySQLDriver@279f2327
Наше соединение:
com.mysql.jdbc.JDBC4Connection@2d8e6db6
Exception in thread "main" java.sql.SQLException: No suitable driver found for some bad url
	at java.sql.DriverManager.getConnection(DriverManager.java:689)
	at java.sql.DriverManager.getConnection(DriverManager.java:270)
	at net.Junior.jdbc.pack00_mysql_simple.App02_MySQLExample_2.main(App02_MySQLExample_2.java:27)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:483)
	at com.intellij.rt.execution.application.AppMain.main(AppMain.java:134)

 */