package net.mr_faton.Multithreading.Monitor.BlockingQueueTest;

/**
 * Created by Faton on 05.11.2014.
 */
public class Producer implements Runnable {
    private int startValue;
    private final int period;
    private final SingleElementBuffer buffer;

    public Producer(int startValue, int period, SingleElementBuffer buffer) {
        this.startValue = startValue;
        this.period = period;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(startValue + " Произведено");
                buffer.put(startValue++);//Тут мы сначала положили в буффер значение startValue, а потом добавили ему единицу, а также, если буффер заполнен, то мы повисаем тут до тех пор, пока не сможем положить элемент в буффер
                Thread.sleep(period);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " был остановлен");
                break;
            }
        }
    }
}
