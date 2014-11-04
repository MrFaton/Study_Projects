package net.mr_faton.Multithreading.Monitor;

/**
 * Created by root on 04.11.2014.
 */
public class App02 {
    public static void main(String[] args) throws InterruptedException {
        Object ref = new Object();
        synchronized (ref) {
            ref.wait(2000);
//            ref.notify();
//            ref.notifyAll();
        }
    }
}
/*Теперь всё работает благодаря тому, что мы синхронизировали секцию для ref с помощью ключевого слова synchronized.
Кстати, если запустить с wait без парамера, то наша порога теперь будет висеть вечно, с параметром она висит в
ожидании 2 сек
 */