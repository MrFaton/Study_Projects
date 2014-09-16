package net.mr_faton.exceptions;

/**
 * Created by root on 11.09.2014.
 */
public class App17 {
    public static void main(String[] args) {
        Error er = new Error("first Error");
        er.addSuppressed(new Error("second Error"));
        er.addSuppressed(new Error("third Error"));
        throw er;
    }
}
//долепливаем исключение с помощью Suppressed