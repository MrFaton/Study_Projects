package net.mr_faton.exceptions;

/**
 * Created by root on 30.08.2014.
 */
public class App06 {
    public static void main(String[] args) {
        System.err.println("0");
        try {
            System.err.println("1");
            if (true) throw new Error();
        } finally {
            System.err.println("2"); //была ошибка или нет, файнали выполнится в любом случае
        }
        System.err.println("3");
    }
}
