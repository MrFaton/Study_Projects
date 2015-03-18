package net.mr_faton.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger(1);
        int y = 1;
        for (int i = 0; i < 5; i++) {
//            int x = counter.getAndIncrement();
            int x = y++;
            System.out.println(x);

        }
    }
}