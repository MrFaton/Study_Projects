package net.mr_faton.exceptions;

/**
 * Created by root on 30.08.2014.
 */
public class App07 {
    public static void main(String[] args) {
        System.err.println("0");
        try {
            System.err.println("1");
            if (true) throw new Error();
        } finally {
            System.err.println("2");
            if (true)
                throw new RuntimeException(); //вылетаем по RuntimeException, хотя изначально должны были вылететь по Error
        }
        System.err.println("3");
    }
}
