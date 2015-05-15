package net.mr_faton.Different_Things;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by root on 15.05.2015.
 */
public class ThreadLocalHandMade {
    public static void main(String[] args) {
        final MyThreadLocal<String> local = new MyThreadLocal<>();
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
class MyThreadLocal<T> {
    private Map<Thread, T> holder = new ConcurrentHashMap<>();

    public T get() {
        return holder.get(Thread.currentThread());
    }

    public void set(T elem) {
        holder.put(Thread.currentThread(), elem);
    }
}
/*
ThreadLocal, который реализован вручную.

Из главного потока видно хелло, а вот уже из другого потока хелло не видно. Удобно педеравать данные между слоями в
многослойных системамах
 */