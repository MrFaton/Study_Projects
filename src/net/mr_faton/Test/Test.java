package net.mr_faton.Test;

import java.sql.*;
import java.util.Collection;

public class Test {

    public static void main(String[] args) throws SQLException {
        String donorMessage = "@Mr_Faton смотри 5 сезон))ууаа такие страсти)";
        long messageID = 522413833873547264L;
        String type = "mention";
        String donorAccount = "Wild_Happiness";
        String donorGender = "female";
        String recipient = "Mr_Faton";
        Date messageDate = new Date(System.currentTimeMillis());

        String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/tweagle?user=Mr_Faton&password=123";//DB at home
        String sql = "" +
                "INSERT INTO " +
                GlobalConstants.DB_NAME + "." + GlobalConstants.TABlE_TWITTER_MESSAGES_N + " " +
                "(" +
                TwitterMessages.MESSAGE + ", " +
                TwitterMessages.ID + ", " +
                TwitterMessages.TYPE + ", " +
                TwitterMessages.OWNER + ", " +
                TwitterMessages.OWNER_GENDER + ", " +
                TwitterMessages.RECIPIENT + ", " +
                TwitterMessages.POSTED_DATE + "" +
                ")" +
                "VALUES (?, ?, ?, ?, ?, ?, ?);";
        Connection connection = DriverManager.getConnection(JDBC_URL);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, donorMessage);
        preparedStatement.setLong(2, messageID);
        preparedStatement.setString(3, type);
        preparedStatement.setString(4, donorAccount);
        preparedStatement.setString(5, donorGender);
        preparedStatement.setString(6, recipient);
        preparedStatement.setDate(7, messageDate);

        System.out.println(preparedStatement.toString());

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }
}