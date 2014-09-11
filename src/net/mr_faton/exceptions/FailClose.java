package net.mr_faton.exceptions;

/**
 * Created by root on 11.09.2014.
 */
public class FailClose implements AutoCloseable {
    private String msg;

    public FailClose(String msg) {
        this.msg = msg;
        System.err.println("new: " + msg);
    }

    public void close() {
        System.err.println("close:" + msg);
        throw new Error(msg);
    }
}
