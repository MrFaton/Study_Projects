package net.mr_faton.Multithreading;

/**
 * Created by root on 06.11.2014.
 */
public class App06 {
    public static void main(String[] args) {
        for (int k=0; k<5; k++){
            final int tmp=k;//нужно уточнить вопрос: "Почему если мы из анононимного класса используем локальные переменные они должны быть финальными?"
            new Thread(new Runnable() {
                public void run() {
                    hello(tmp);
                }
            }).start();
        }
    }

    public synchronized static void hello(int id){
        //*************
        System.out.println("Поток: "+id+" зашёл в метод hello и находится перед wait() |* - wait - sleep, " + System.currentTimeMillis());
        try {
            App06.class.wait(5000);
        } catch (InterruptedException ignore) {/*NOP*/}
        System.out.println("Поток: "+id+" прошёл wait() и сейчас перед sleep() | wait - * - sleep, " + System.currentTimeMillis());
        //*************
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ignore) {/*NOP*/}
        System.out.println("Поток: "+id+" вышел из sleep() | wait - sleep - *, " + System.currentTimeMillis());
        //*************
    }
}