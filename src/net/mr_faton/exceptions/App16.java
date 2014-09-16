package net.mr_faton.exceptions;

/**
 * Created by root on 11.09.2014.
 */
public class App16 {
    public static void main(String[] args) {
        try (FailClose x = new FailClose("xxx"); FailClose y = new FailClose("yyy")) {
            System.err.println("body");
        }
    }
}
//Error в методе close