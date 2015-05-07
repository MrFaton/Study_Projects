package net.Junior.spring.app04_full_spring_dependency_injection_on_xml.aspect;

import org.aspectj.lang.JoinPoint;

/**
 * Created by root on 07.05.2015.
 */
public class ExceptionLogger {
    public void logException(JoinPoint joinPoint, Throwable throwable) {
        System.out.println("****** ASPECT.ExceptionLogger:Was exception in method: \"" + joinPoint.toShortString() +
                "\" Message is: " + throwable.getMessage());
    }
}
/*
Аспект, который логирует любой метод, из которого вылетает исключение
 */