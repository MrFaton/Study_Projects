package net.mr_faton.Test;

import java.io.InputStream;
import java.util.Set;
import java.util.SortedSet;

public class Test {

    public static void main(String[] args) {

    }

    public synchronized void ff() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void dd() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}