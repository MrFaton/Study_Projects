package net.mr_faton.Multithreading.LB;

/**
 * Created by root on 04.11.2014.
 */
public class ProrabRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Прораб начал работать...");
        for (int i = 0; i < 10; i++) {
            //A&B
            Runnable printA = new PrintRunnable("A   .", 100);
            Thread threadA = new Thread(printA);
            threadA.start();
            Runnable printB = new PrintRunnable(".   B", 99);
            Thread threadB = new Thread(printB);
            threadB.start();
            try {
                threadA.join();
                threadB.join();
                System.out.println("Прораб ожидает завершения работы потоков A и B");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //C
            System.out.println("-----");
            Runnable printC = new PrintRunnable("   C", 100);
            Thread threadC = new Thread(printC);
            threadC.start();
            try {
                threadC.join();
                System.out.println("Прораб ожидает завершения работы потока C");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("-----");
        }
        System.out.println("Прораб закончил работать...");
    }
}
