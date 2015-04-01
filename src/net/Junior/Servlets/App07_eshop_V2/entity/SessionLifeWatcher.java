package net.Junior.Servlets.App07_eshop_V2.entity;

import net.Junior.Servlets.App07_eshop_V2.session.SessionOnServerRepository;
import net.Junior.Servlets.App07_eshop_V2.session.Session_User;
import net.Junior.Servlets.App07_eshop_V2.statements.Statements;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Map;

/**
 * Created by Mr_Faton on 31.03.2015.
 */
public final class SessionLifeWatcher implements ServletContextListener {
    private SessionOnServerRepository sessionOnServerRepository = SessionOnServerRepository.getInstance();
    private Thread sessionLifeWatcherThread = null;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("-----> SessionLifeWatcher: contextInitialized()");
        sessionLifeWatcherThread = new Thread(new RunnableImpl());
        sessionLifeWatcherThread.start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        if (sessionLifeWatcherThread != null) {
            sessionLifeWatcherThread.interrupt();
        }
    }

    private class RunnableImpl implements Runnable {
        @Override
        public void run() {
            System.out.println("-----> RunnableImpl: run()");
            while (true) {
                try {
                    //если на сервере есть 1 или больше сессий
                    if (sessionOnServerRepository.getSessionCount() != 0) {
                        /*
                        получаем сессию с минимальным колличеством времени жизни по отношению к текущему времени,
                        отнимает от неё текущее время и получаем время спячки потоко преде новой проверкой на удаление
                        этой сесси. Новая проверка нужна, т.к. за время спячки этого потока-убицы сессий, сессией могли
                        воспользоваться и время её жзни могло продлиться. Например сейчас 12:03. У нас есть сессии,
                        время жизни которых истекает в 12:08, 12:05 и в 12:15, будет возвращено время 12:05, затем от
                        12:05 отнимем 12:03 и получи 2 минуты спячки потока-убийцы сессий
                         */
                        long sleepTime = checkAndRemoveSession() - System.currentTimeMillis();
                        System.out.println("-----> RunnableImpl: sleepTime = " + sleepTime);
                        // метод checkAndRemoveSession() может убить сессию и вернуть отрицательное время для спячки, поэтому, если это произошло, то проверяем сесси заново не ложась спсть
                        if (sleepTime > 1000) {
                            System.out.println("-----> RunnableImpl: sleep by sleepTime");
                            Thread.currentThread().sleep(sleepTime);
                        }
                    } else {
                        //если в хранилище нет сессий, то тогда спим по дефолтному времени
                        System.out.println("-----> RunnableImpl: sleep by default");
                        Thread.currentThread().sleep(Statements.PARAM_SLEEP_TIME);
                    }
                } catch (InterruptedException e) {
                    return;
                }
            }
        }

        //возвращает минимальное время жизни сессии, а также если оно меньше 1 сек, то удаляет её
        private long checkAndRemoveSession() {
            System.out.println("-----> RunnableImpl: checkAndRemoveSession()");
            Map<String, Session_User> sessionsMap = sessionOnServerRepository.getSessionsMap();
            Long minSessionExpiration = Long.MAX_VALUE;
            String sessionId = "";
            //время жизни сессии
            long expiration;
            for (Map.Entry<String, Session_User> element : sessionsMap.entrySet()) {
                expiration = element.getValue().getExpiration();
                if (minSessionExpiration > expiration) {
                    minSessionExpiration = expiration;
                    sessionId = element.getKey();
                }
            }
            //если время жизни сессии меньше 1 секунды, то удаляем её
            if ((minSessionExpiration - System.currentTimeMillis()) <= 1000) {
                System.out.println("-----> RunnableImpl: checkAndRemoveSession(): need to remove session");
                sessionOnServerRepository.removeSession(sessionId);
            }
            return minSessionExpiration;
        }

        private void removeSession(String sessionId) {
            System.out.println("-----> RunnableImpl: removeSession()");
            if (sessionId == null || sessionId.length() == 0) {
                throw new IllegalArgumentException("bad sessionId");
            }
            sessionOnServerRepository.removeSession(sessionId);
        }
    }
}

/*
Очиститель сессий. Состоит из 2-х классов.
1-ый класс.
SessionLifeWatcher имплементит ServletContextListener. Его метод contextInitialized() запускается лишь однажды,
когда Томкат стартанул и поднял приложение. В этом методе запскается отдельный поток, который следит за сессиями на
сервере и если время жизни сессии вышло, он её удаляет из хранилища.

2-ой класс.
RunnableImpl имплементит Runnable. В его методе run() заключаеся вся задача по контролю за сессиями.
 */