package net.mr_faton.Different_Things.Twitter;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Set;

public class Test1 {
    private static Connection connection;
    private static final String SQL = "INSERT INTO tweagle.synonyms (word, synonyms) VALUES (?,?);";
    private static Set<String> uniqueWords;

    public static void main(String[] args) throws SQLException {
        int total = 97516;
        int current = 0;
        int percent = -1;
        String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/tweagle?user=Mr_Faton&password=123";
        uniqueWords = new UniqueWordCollection().getUniqueWordCollection();
        connection = DriverManager.getConnection(JDBC_URL);
        connection.setAutoCommit(false);
        try {
            Scanner scanner = new Scanner(new FileInputStream("C:\\RusSyn.txt"), "windows-1251");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] lineTokens = line.split("-");

                String word = lineTokens[0].trim();
                if (word.contains(" ")) {
                    continue;
                }
                if (!uniqueWords.contains(word)) {
                    continue;
                }

                String[] synonymsTokens = lineTokens[1].split(",");
                StringBuilder synonyms = new StringBuilder();
                for (String synonym : synonymsTokens) {
                    if (!synonym.contains("(") && !synonym.contains(")")) {
                        synonyms.append(synonym + ",");
                    }
                }
                if (synonyms.length() <= 0) {
                    continue;
                }
                synonyms.replace(synonyms.lastIndexOf(","), synonyms.length(), "");
                insert(word, synonyms.toString());

            }
            connection.commit();
        } catch (SQLException | FileNotFoundException ex) {
            connection.rollback();
            ex.printStackTrace();
        } finally {
            connection.close();
        }
    }

    private static void insert(String word, String synonyms) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setString(1, word);
        preparedStatement.setString(2, synonyms);
        preparedStatement.executeUpdate();
    }
}
/*
коммент
 */