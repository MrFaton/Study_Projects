package net.Junior.jdbc.pack01_table_operation;

/**
 * Created by Mr_Faton on 03.06.2015.
 */
public class App06_getColumnNames {
    String sql = "SELECT `COLUMN_NAME` FROM `INFORMATION_SCHEMA`.`COLUMNS`\n" +
            " WHERE `TABLE_SCHEMA`='tweagle' and `TABLE_NAME`='twitter_users'\n" +
            " AND   `COLUMN_NAME` LIKE '%tweet%'";
}
