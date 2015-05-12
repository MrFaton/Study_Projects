package net.Junior.jdbc.app00_mysql_simple;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Mr_Faton on 12.05.2015.
 */
public class App06_OpenCloseConnectionTime {
    public static final String JDBC_URL =
            "jdbc:mysql://127.0.0.1:3306/my_test_db?user=Mr_Faton&password=123";//DB at my home
//    public static final String JDBC_URL =
//            "jdbc:mysql://192.168.101.1:3306/my_test_db?user=Mr_Faton&password=123";//DB at my work

    public static void main(String[] args) throws SQLException {
        Driver driver = new com.mysql.jdbc.Driver();
        for (int i = 0; i < 200; i++) {
            long t1 = System.currentTimeMillis();
            try (Connection conn = driver.connect(JDBC_URL, new Properties())) {/*NOPE*/}
            long t2 = System.currentTimeMillis();
            System.out.println(t2 - t1);
        }
    }
}
/*
Средняя скорость открыл/закрыл коннекшон 3 миллиСекунды - это очень много
 */