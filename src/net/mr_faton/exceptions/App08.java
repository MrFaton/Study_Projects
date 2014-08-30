package net.mr_faton.exceptions;

/**
 * Created by root on 30.08.2014.
 */
public class App08 {
    public static void main(String[] args) {
        System.err.println(f());

    }

    private static int f() {
        try {
            return 0;
        } finally {
            return 1;
//            throw new Error();//можно сломаться
        }
    }
}
//что напечатает