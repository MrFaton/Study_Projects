package net.mr_faton.Multithreading.Monitor.BlockingQueueTest;

/**
 * Created by Faton on 05.11.2014.
 */
public class SingleElementBuffer {
    private Integer elem = null;

    public synchronized void put(int newElem) throws InterruptedException {
        while (this.elem != null) {
            this.wait();//описание метода приведено ниже
        }
        this.elem = newElem;
        this.notifyAll();//описание метода приведено ниже // notifyAll - будит всех, кто ждал в get
    }

    public synchronized int get() throws InterruptedException {
        while (this.elem == null) {
            this.wait();//описание метода приведено ниже
        }
        Integer result = this.elem;
        this.elem = null;
        this.notifyAll();//описание метода приведено ниже
        return result;
    }
}
//wait, notify, notifyAll можно вызывать у нестатического синхронизированного метода, т.е. вызывать можну у this