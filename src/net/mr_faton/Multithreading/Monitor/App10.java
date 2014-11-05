package net.mr_faton.Multithreading.Monitor;

/**
 * Created by root on 04.11.2014.
 */
public class App10 {
    public static void main(String[] args) throws InterruptedException {
        Object ref0 = new Object();
        Object ref1 = ref0;
        synchronized (ref0) {
            ref1.wait(2000);
        }
    }
}
//Синхронизация происходит не по ссылке, а по тому, на что указывает ссылка