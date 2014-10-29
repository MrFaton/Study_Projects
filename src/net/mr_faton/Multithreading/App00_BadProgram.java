package net.mr_faton.Multithreading;

/**
 * Created by root on 29.10.2014.
 */
public class App00_BadProgram {
    public static final int N=1000_000_000;
    public static int counter=0;

    public static void main(String[] args) throws InterruptedException {
        Thread t0=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int k=0; k<N; k++) counter++;
            }
        });
        t0.start();

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int k=0; k<N; k++) counter++;
            }
        });
        t1.start();

        t0.join();//это присоединиться и подождать покапоток закончит свою работу.
        t1.join();

        System.out.println(counter);
    }
}
/* Программа будет работать некорректно. Смысл пограммы был в том, чтобы каждый из двух потоков добавлял к counter
1 и того в результате работы программы counter должен быть равен 2000_000_000. А результат при выводе каждый раз разный (т.е.
counter каждый раз разный).
 */