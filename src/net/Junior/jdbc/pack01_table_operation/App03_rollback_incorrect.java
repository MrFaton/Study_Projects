package net.Junior.jdbc.pack01_table_operation;

import java.sql.*;

/**
 * Created by Mr_Faton on 13.05.2015.
 */
public class App03_rollback_incorrect {
    public static final String JDBC_URL =
            "jdbc:mysql://127.0.0.1:3306/my_test_db?user=Mr_Faton&password=123";

    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection(JDBC_URL)) {
            connection.setAutoCommit(false);

            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE IF EXISTS temp_table");
            statement.executeUpdate("CREATE TABLE temp_table (id INT, name VARCHAR (64))");
            statement.executeUpdate("INSERT INTO temp_table (id, name) VALUES (1, 'Bob')");
            statement.executeUpdate("INSERT INTO temp_table (id, name) VALUES (2, 'Anna')");

            connection.rollback();

            ResultSet resultSet = statement.executeQuery("SELECT id, name FROM temp_table");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println(id + " " + name);
            }
        }
    }
}
/*
По умолчанию AutoCommit(true), поэому после каждого execute происходит коммит и поэтому rollback не имеет смысла, т.к.
коммит завершает транзакцию, а роллбек может откатить изменения только в одной транзакции.
Это не совсем корректный код, т.к. при любом SQLException-е у нас не будет отката назад, т.е. роллбека.
Более корректрый код представлен в App04
 */