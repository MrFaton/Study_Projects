package net.Junior.spring.app01_spring_dependency_injection;

/**
 * Created by root on 29.04.2015.
 */
public class App01_Start {
    public static void main(String[] args) {
        MainDemoBean mainDemoBean = new MainDemoBean();
        mainDemoBean.inject();
        mainDemoBean.begin();
    }
}
