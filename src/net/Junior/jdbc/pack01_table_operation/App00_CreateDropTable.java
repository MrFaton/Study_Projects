package net.Junior.jdbc.pack01_table_operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Mr_Faton on 13.05.2015.
 */
public class App00_CreateDropTable {
    public static final String JDBC_URL =
            "jdbc:mysql://127.0.0.1:3306/my_test_db?user=Mr_Faton&password=123";//DB at my home
//    public static final String JDBC_URL =
//            "jdbc:mysql://192.168.101.1:3306/my_test_db?user=Mr_Faton&password=123";//DB at my work

    public static void main(String[] args) throws SQLException {
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE temp_table (id INT, name VARCHAR(64));");//создать таблицу
//            stmt.executeUpdate("DROP TABLE IF EXISTS temp_table;");//удалить таблицу
        }
    }
}
/*
execute - для выполнинея любых комманд
executeQuery - только для SELECT
executeUpdate - только для insert, update, delete

Обычну пишут ключевые слова sql-я большими буквами: CREATE TABLE
 */