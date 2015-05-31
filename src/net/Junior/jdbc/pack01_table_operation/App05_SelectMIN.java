package net.Junior.jdbc.pack01_table_operation;

import java.sql.*;

/**
 * Created by Mr_Faton on 13.05.2015.
 */
public class App05_SelectMIN {
//    public static final String JDBC_URL =
//            "jdbc:mysql://127.0.0.1:3306/my_test_db?user=Mr_Faton&password=123";//DB at my home
    public static final String JDBC_URL =
            "jdbc:mysql://192.168.101.1:3306/my_test_db?user=Mr_Faton&password=123";//DB at my work

    public static void main(String[] args) throws SQLException {
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DROP TABLE IF EXISTS temp_table");
            stmt.executeUpdate("CREATE TABLE temp_table (col1 INT, col2 INT, col3 INT)");
            stmt.executeUpdate("INSERT INTO temp_table (col1, col2, col3) VALUES (3, 9, 8)");
            stmt.executeUpdate("INSERT INTO temp_table (col1, col2, col3) VALUES (1, 4, 6)");
            stmt.executeUpdate("INSERT INTO temp_table (col1, col2, col3) VALUES (5, 6, 9)");

            //выбрать минимальное значение из трёх колонок для каждной строке
            ResultSet resultSet = stmt.executeQuery("SELECT LEAST(col1, col2, col3) FROM my_test_db.temp_table");
            while (resultSet.next()) {
                System.out.println("Самым маленьким значением в строке является: " + resultSet.getInt(1));
            }
            System.out.println("***");

            //выбрать минимальное значение из трёх колонок для всей таблици
            resultSet = stmt.executeQuery("SELECT MIN(LEAST(col1, col2, col3)) FROM my_test_db.temp_table");
            resultSet.next();
            System.out.println("Самое маленькое значение во всей таблице из 3-х колонок: " + resultSet.getInt(1));
        }
    }
}
/*
Везде в resultSet.getInt(1) стоит 1 потому что результатом будет одна колонка
 */