package net.mr_faton.Test;

import net.Junior.Servlets.App07_eshop_V2.entity.JSessionIdCreator;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        final JSessionIdCreator jSessionIdCreator = new JSessionIdCreator();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(jSessionIdCreator.generateID());
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(jSessionIdCreator.generateID());
            }
        }).start();
    }
}