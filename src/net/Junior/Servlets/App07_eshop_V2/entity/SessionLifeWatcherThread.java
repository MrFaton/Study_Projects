package net.Junior.Servlets.App07_eshop_V2.entity;

import net.Junior.Servlets.App07_eshop_V2.session.SessionOnServerRepository;

/**
 * Created by Mr_Faton on 31.03.2015.
 */
public class SessionLifeWatcherThread implements Runnable {
    private final SessionLifeWatcher sessionLifeWatcher = SessionLifeWatcher.getInstance();
    private final SessionOnServerRepository sessionOnServerRepository = SessionOnServerRepository.getInstance();
    private static long sleepTime = 10_000;
    @Override
    public void run() {
        System.out.println("------> SessionLifeWatcherThread is run");
        while (true) {
            System.out.println("------> SessionLifeWatcherThread start while");
            if (sessionOnServerRepository.getSessionsMap().size() == 0) {
                try {
                    System.out.println("------> SessionLifeWatcherThread before sleep at sleepTime");
                    Thread.currentThread().sleep(sleepTime);
                    System.out.println("------> SessionLifeWatcherThread after sleep at sleepTime");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
            } else {
                try {
                    System.out.println("------> SessionLifeWatcherThread before sleep at sessionExpiration");
                    long sleeppy = sessionLifeWatcher.checkAndRemoveSession() - System.currentTimeMillis();
                    if (sleeppy > 1000) {
                        System.out.println("------> SessionLifeWatcherThread need sleep " + sleeppy);
                        Thread.currentThread().sleep(sleeppy);
                        System.out.println("------> SessionLifeWatcherThread after sleep at sessionExpiration");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
            }
        }
    }
}
/*
тут
 */