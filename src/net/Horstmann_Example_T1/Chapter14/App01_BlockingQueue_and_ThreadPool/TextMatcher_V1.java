package net.Horstmann_Example_T1.Chapter14.App01_BlockingQueue_and_ThreadPool;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * Created by root on 04.02.2015.
 */
public class TextMatcher_V1 {
    //размер блокирующей очереди
    private static final int QUEUE_SIZE = 200;
    //максимальное колличество потоков в пуле
    private static final int MAX_POOL_SIZE = 64;
    //колличество корневых потоков в пуле
    private static final int ROOT_THREADS = 4;
    //время жизни потока
    private static final long THREAD_LIFE_TIME = 3L;
    //путь к папке, в которой будем искать файлы в корне и во всех подпапках
    private static File directoryPath;
    //ключевое слово, которое нужно найти
    private static String keyWord;
    //пулл потоков
    private static ExecutorService threadPool;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Ввести путь к папке (например: X:\\Faton\\Java):");
        directoryPath = new File(in.nextLine());
        System.out.println("Ключевое слово (например: volatile):");
        keyWord = in.nextLine();

        //создаём объект блокирующей очереди ArrayBlockingQueue типа BlockingQueue
        BlockingQueue<File> queue = new ArrayBlockingQueue<>(QUEUE_SIZE);
        //создаём пул потоков
        threadPool = new ThreadPoolExecutor(ROOT_THREADS, MAX_POOL_SIZE,
                THREAD_LIFE_TIME, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2000));
        //время старта работы
        long workTime = System.currentTimeMillis();
        //создаём и запускаем поток-поисковик файлов
        new Thread(new FileSearcher(directoryPath, queue)).start();
        //создаём и запускаем поток-обработчики файлов
        Thread handle = new Thread(new FileHandler(keyWord, queue, threadPool));
        handle.start();
        try {
            //ожидаем завершения  работы потока-обработчика
            handle.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //вычисляем и выводим общее время работы программы в миллисекундах
        workTime = System.currentTimeMillis() - workTime;
        System.out.println("Работа завершена за: " + workTime);
    }
}
/*
Принци работы этого класса не отличается от остальных версий.
Единственное отличие - это тип созданного пула потоков.
Тут пул реализован при помощи ThreadPoolExecutor. Как она работает?
Когда пул создан в нём нет ни единого потока. Как только мы даём ему задачу на выполнение (метод submit) пул потоков
создаёт внутри себя поток, который выполняет эту задачу.
++Если поток выполнил задачу, а время его жизни ещё не истекло, и мы добавляем в пул новую задачу, то задача
выполняется в этом же потоке (нового потока не создаётся).
++Если созданный поток в пуле выполняет задачу, а мы добавляем новую, то пул потоков проверяет колличество максимально
разрешённых потоков в пуле (потолок потоков, т.е. сколько максимум потоков может работать в пуле) и создаёт новый поток,
если количество работающих потоков меньше потолка потоков в пуле. И работает уже 2 потока одновременно.
++Если количество работающих потоков равно максимальному колличеству потоков в пуле, а мы добавляем новую задачу на
выполнение, то экземпляр класса Runnable или Callable, в котором содержится задача, помещается в блокирующу очередь
new ArrayBlockingQueue<Runnable>(2000)). Как только один из потоков в пуле освобождается, он берёт задачу на выполнение
из очереди.
++Если и эта блокирующая очередь заполнена, а задачи всё поступают, нужно определить обработчик RejectedExecutionHandler.
++Если созданные потоки выполнили свои задачи и простаивают, у них есть время жизни THREAD_LIFE_TIME(long).
А также определяется тип этогов времени при помощи TimeUnit.SECONDS. Если в течении этого времени в поток не поступало
задач - ОН УДАЛЯЕТСЯ! Остаётся лишь колличество коренных потоков ROOT_THREADS.

Переменные ThreadPoolExecutor:

ROOT_THREADS - кол-во коренных потоков, когда создалось много потоков, затем они удаляются по ненадобности и остаётся
минимум это количество постоянно работающих потоков
MAX_POOL_SIZE - максимальное количество работающих в пуле потоков
THREAD_LIFE_TIME - время жизни потока без работы
TimeUnit.SECONDS - тип времени жизни потока
ArrayBlockingQueue<Runnable>(2000) - очередь, в которую попадают задачи, если все потоки работают и заняты.

Т.е. прикол этого пула потоков:
Сначала потоков нет, потом они создаются до определённого предела по необходимости, далее удаляются если простаивают
без работы определённое количество времени.

На этой задаче этот класс показал среднее время работы.
 */