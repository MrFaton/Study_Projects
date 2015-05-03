package net.Junior.spring.app03_spring_aop_simple.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by root on 03.05.2015.
 */
public class SimpleLogger {
    public Object log(ProceedingJoinPoint proceedingJP) throws Throwable {
        try {
            System.out.println("****** ASPECT.SimpleLogger: try to call method: " + proceedingJP.toShortString());
            return proceedingJP.proceed();
        } finally {
            System.out.println("****** method was called");
        }
    }
}
