package net.Junior.spring.app04_full_spring_dependency_injection_on_xml.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by root on 03.05.2015.
 */
@Aspect
public class SimpleLogger {
    public Object log(ProceedingJoinPoint proceedingJP) throws Throwable {
        try {
            String threadName = Thread.currentThread().getName();
            System.out.println("****** ASPECT.SimpleLogger: thread - " + threadName + " try to call method: " + proceedingJP.toShortString());
            if (!threadName.equals("main")) {
                System.out.println("++++thread isn't Main Thread, so access denied");
                return null;
            }
            return proceedingJP.proceed();
        } finally {
            System.out.println("****** method was called");
        }
    }
}
/*
Логирует вызов любого метода
 */