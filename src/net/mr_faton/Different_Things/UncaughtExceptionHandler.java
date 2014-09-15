package net.mr_faton.Different_Things;

import java.io.FileInputStream;

/**
 * Created by root on 15.09.2014.
 */
public class UncaughtExceptionHandler {
    public static void main(String[] args) throws Exception{
        Thread.currentThread().setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Плохо.., проблемки с потоком "+t+" и вылетели по эксепшонсу "+e.getClass());
            }
        });
        new FileInputStream ("  dadsfasf  ");
    }
}
