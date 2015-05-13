package net.Junior.jdbc.pack01_table_operation;

import java.sql.*;

/**
 * Created by Mr_Faton on 13.05.2015.
 */
public class App01_InsertGetData_byName {
    public static final String JDBC_URL =
            "jdbc:mysql://127.0.0.1:3306/my_test_db?user=Mr_Faton&password=123";//DB at my home
    //    public static final String JDBC_URL =
//            "jdbc:mysql://192.168.101.1:3306/my_test_db?user=Mr_Faton&password=123";//DB at my work

    public static void main(String[] args) throws SQLException {
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            Statement stmt = conn.createStatement();
            /*
            если мы собираемся создавать новую таблицу, то лучше проверить и если уже есть такая таблица, то удалить
            её, потому что возможно это уже не первая попытка создать такую же таблицу и возможно предыдущие попытки
            создания не увенчались успехом и это на самом деле какой-то огрызок таблицы. Поэтому лучше сначала
            удалять если существует, а потом создавать новую
             */
            //заполнить таблицу, вставить данные
            stmt.executeUpdate("DROP TABLE IF EXISTS temp_table");
            stmt.executeUpdate("CREATE TABLE temp_table (id INT, name VARCHAR (64))");
            stmt.executeUpdate("INSERT INTO temp_table (id, name) VALUES (1, 'Alex')");
            stmt.executeUpdate("INSERT INTO temp_table (id, name) VALUES (2, 'Judi')");//правильней делать executeUpdate
            stmt.execute("INSERT INTO temp_table (id, name) VALUES (3, 'Mike')");//можно и так, но лучше executeUpdate

            //получить данные из таблицы
            ResultSet resultSet = stmt.executeQuery("SELECT id, name FROM temp_table");
//            ResultSet resultSet = stmt.execute("SELECT id, name FROM temp_table");//можно и так, но лучше executeQuery

            System.out.println("Полученные данные:");
            while (resultSet.next()) {
                //тут мы получаем данные по имени getInt("id")
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println(id + " " + name);
            }
        }
    }
}
