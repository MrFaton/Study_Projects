package net.mr_faton.Multithreading.LB;

/**
 * Created by Faton on 03.11.2014.
 */
public class PrintRunnable_Done implements Runnable {
    private int count;

    public PrintRunnable_Done(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(spaces(count) + count);
        }

        Runnable printer = new PrintRunnable_Done(count + 1);
        Thread thread = new Thread(printer);
        thread.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static String spaces(int count) {
        String result = " ";
        for (int i = 0; i < count; i++) {
            result += " ";
        }
        return result;
    }
}
