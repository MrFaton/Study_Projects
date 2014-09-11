package net.mr_faton.exceptions;

/**
 * Created by root on 11.09.2014.
 */
public class FailCreate implements AutoCloseable {
    private String msg;

    public FailCreate(String msg) {
        this.msg = msg;
        System.err.println("new:" + msg);
        throw new Error();
    }

    public void close() {
        System.err.println("close:" + msg);
    }
}
