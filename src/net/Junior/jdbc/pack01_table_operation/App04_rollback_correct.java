package net.Junior.jdbc.pack01_table_operation;

import java.sql.*;

/**
 * Created by Mr_Faton on 13.05.2015.
 */
public class App04_rollback_correct {
    public static final String JDBC_URL =
            "jdbc:mysql://127.0.0.1:3306/my_test_db?user=Mr_Faton&password=123";

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(JDBC_URL);
        try {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE IF EXISTS temp_table");
            statement.executeUpdate("CREATE TABLE temp_table (id INT, name VARCHAR (64))");
            statement.executeUpdate("INSERT INTO temp_table (id, name) VALUES (4, 'Pit')");
            statement.executeUpdate("INSERT INTO temp_table (id, name) VALUES (2, 'Bart')");
            connection.commit();

            ResultSet resultSet = statement.executeQuery("SELECT id, name FROM temp_table");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println(id + " " + name);
            }
        } catch (SQLException ex) {
            if (connection != null) {
                connection.rollback();
            }
            throw ex;
        }
    }
}
/*
Обязательно в конеце должен быть commit!
Теперь при выполноении серии sql-ин в рамках одной транзакции если хоть где-нибудь произойдёт сбой, то мы всегда может
откатиться назад до иземенений.
 */