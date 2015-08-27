package net.Junior.jdbc.pack01_table_operation;

import java.sql.*;

/**
 * Created by root on 27.08.2015.
 */
public class App07_BatchExample {
    public static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/my_test_db?user=Mr_Faton&password=123";

    public static void main(String[] args) {
        try(Connection connection = DriverManager.getConnection(JDBC_URL)) {

            //Example with Statement
            String sql1 = "INSERT INTO db_name (id, name) VALUES (1, 'Mike');";
            String sql2 = "INSERT INTO db_name (id, name) VALUES (2, 'Alex');";

            String[] queries1 = {sql1, sql2};
            Statement statement = connection.createStatement();
            for (String query : queries1) {
                statement.addBatch(query);
            }
            statement.executeBatch();
            statement.close();


            //Example with PreparedStatement
            String templateSql = "INSERT INTO db_name (id, name) VALUES (?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(templateSql);

            preparedStatement.setInt(1, 3);
            preparedStatement.setString(2, "Judi");
            preparedStatement.addBatch();

            preparedStatement.setInt(1, 4);
            preparedStatement.setString(2, "Ann");
            preparedStatement.addBatch();

            preparedStatement.executeBatch();
            preparedStatement.close();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
