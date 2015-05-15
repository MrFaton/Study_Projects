package net.mr_faton.Different_Things;

/**
 * Created by root on 15.05.2015.
 */
public class InheritableThreadLocalTest {
    public static void main(String[] args) {
        final InheritableThreadLocal<String> local = new InheritableThreadLocal<>();
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
Теперь у нас доступны данные в дочернем потоке, которые мы положили в главном потоке
 */