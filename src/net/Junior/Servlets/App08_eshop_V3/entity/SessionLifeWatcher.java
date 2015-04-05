package net.Junior.Servlets.App08_eshop_V3.entity;

import net.Junior.Servlets.App08_eshop_V3.session.SessionOnServerRepository;
import net.Junior.Servlets.App08_eshop_V3.session.Session_User;
import net.Junior.Servlets.App08_eshop_V3.statements.Statements;

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
                    if (sessionOnServerRepository.getSessionCount() != 0) {
                        long sleepTime = checkAndRemoveSession() - System.currentTimeMillis();
                        System.out.println("-----> RunnableImpl: sleepTime = " + sleepTime);
                        if (sleepTime > 1000) {
                            System.out.println("-----> RunnableImpl: sleep by sleepTime");
                            Thread.currentThread().sleep(sleepTime);
                        }
                    } else {
                        System.out.println("-----> RunnableImpl: sleep by default");
                        Thread.currentThread().sleep(Statements.PARAM_SLEEP_TIME);
                    }
                } catch (InterruptedException e) {
                    return;
                }
            }
        }

        private long checkAndRemoveSession() {
            System.out.println("-----> RunnableImpl: checkAndRemoveSession()");
            Map<String, Session_User> sessionsMap = sessionOnServerRepository.getSessionsMap();
            Long minSessionExpiration = Long.MAX_VALUE;
            String sessionId = "";
            long expiration;
            for (Map.Entry<String, Session_User> element : sessionsMap.entrySet()) {
                expiration = element.getValue().getExpiration();
                if (minSessionExpiration > expiration) {
                    minSessionExpiration = expiration;
                    sessionId = element.getKey();
                }
            }
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