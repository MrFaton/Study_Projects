package net.Junior.spring.app03_spring_aop_simple;

import net.Junior.spring.app03_spring_aop_simple.api.WorkerWhoUsesAPI;

/**
 * Created by root on 03.05.2015.
 */
public class StartApp {
    public static void main(String[] args) {
        WorkerWhoUsesAPI worker = new WorkerWhoUsesAPI();
        worker.inject();
        worker.useApi();
    }
}
