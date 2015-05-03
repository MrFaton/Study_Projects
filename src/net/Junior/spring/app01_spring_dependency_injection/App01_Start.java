package net.Junior.spring.app01_spring_dependency_injection;

/**
 * Created by root on 29.04.2015.
 */
public class App01_Start {
    public static void main(String[] args) {
        //конструируем объект основного бина, который будет использовать другие бины
        MainDemoBean mainDemoBean = new MainDemoBean();
        //проводим инъекцию
        mainDemoBean.inject();
        //тестируем результат
        mainDemoBean.begin();
    }
}
