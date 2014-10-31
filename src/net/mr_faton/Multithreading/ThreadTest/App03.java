package net.mr_faton.Multithreading.ThreadTest;

/**
 * Created by Faton on 30.10.2014.
 */
public class App03 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int n = 0; n < 5; n++) {
                    sillyWork();
                    System.out.println("Новый поток: Hello!");
                }
            }
        }).start();

        for (int m = 0; m < 5; m++) {
            sillyWork();
            System.out.println("Главный поток: Bye!");
        }
    }

    public static void sillyWork() {
        double d = 2.0;
        for (int k = 0; k < 10_000_000; k++) {
            d = Math.sin(d);
        }
    }
}
