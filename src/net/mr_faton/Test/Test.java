package net.mr_faton.Test;

import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test {
    public static void main(String[] args) {
        String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/tweagle?user=Mr_Faton&password=123";//DB at home
        String sql =
                "SELECT next_tweet, next_mention, next_retweet, next_dm, next_follow, next_followback, next_unfollow, " +
                        "next_ac_text_status " +
                        "FROM tweagle.twitter_users;";

        String SELECT_SQL = "SELECT MIN(LEAST);";
        try (Connection connection = DriverManager.getConnection(JDBC_URL)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                long result = resultSet.getLong(1);
                System.out.println(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}