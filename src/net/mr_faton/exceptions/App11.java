package net.mr_faton.exceptions;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Faton on 10.09.2014.
 */
public class App11 {
    public static void main(String[] args) throws IOException, SQLException {
        try {
            if (System.nanoTime() % 2 == 0) {
                throw new IOException();
            } else {
                throw new SQLException();
            }
        } catch (IOException | SQLException ex) {
            System.out.println("Поймали одно из двух эксепшенсов");
            throw ex;
        }
    }
}
//Мульти кетч, когда мы в одном кетче ловим несколько исключений, но выполняем одно и тоже действие,
//символ "|" означает "или"