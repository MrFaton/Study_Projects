package net.mr_faton.Multithreading.KillThread;

/**
 * Created by Faton on 10.11.2014.
 */
public class App03_interrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread myThread = Thread.currentThread();//Интересный факт. Тут нам нужна ссылка на самого себя, то есть нужна ссылка thread, но thread ещё как бы не создан, его конструктор ещё не отработал до конца, чтобы пользоваться ссылкой thread, поэтому, чтобы в данный момент внутри конструктора получить ссылку на самого себя мы испльзуем такую конструкцию
                while (true) {
                    System.out.println(myThread.isInterrupted());
                    double d = 2;
                    for (int k = 0; k < 10_000_000; k++) {
                        d = Math.sin(d);
                    }
                }
            }
        });
        System.out.println("Уведомлён ли поток о том, что ему надо завершиться?");
        thread.start();
        Thread.sleep(1000);
        System.out.println("Уведомлён ли он после interrupt?");
        thread.interrupt();
    }
}
