package net.mr_faton.Different_Things;

/**
 * Created by root on 15.05.2015.
 */
public class ThreadLocalTest1 {
    public static void main(String[] args) {
        final ThreadLocal<String> local = new ThreadLocal<>();
        System.out.println(Thread.currentThread().getName() + ":" + local.get());
        local.set("hello");
        new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + ":" + local.get());
            }
        }).start();
        System.out.println(Thread.currentThread().getName() + ":" + local.get());
    }
}
/*
Из главного потока видно хелло, а вот уже из другого потока хелло не видно. Удобно педеравать данные между слоями в
многослойных системамах
 */