package net.Junior.spring.app03_spring_aop_simple.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

/**
 * Created by root on 03.05.2015.
 */
public class SimpleLogger {
    public Object log(ProceedingJoinPoint proceedingJP) throws Throwable {
        try {

            System.out.println("****** ASPECT.SimpleLogger: try to call method: " + proceedingJP.toShortString());
            System.out.println(proceedingJP.getSignature());
            System.out.println(Arrays.toString(proceedingJP.getArgs()));
            return proceedingJP.proceed();
        } finally {
            System.out.println("****** method was called");
        }
    }
}
/*
Аспект, который занмается логированием из пакета net.Junior.spring.app03_spring_aop_simple, но только бинов спринга
 */