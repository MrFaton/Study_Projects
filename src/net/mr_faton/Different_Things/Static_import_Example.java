package net.mr_faton.Different_Things;

import static java.lang.Math.sin;

/**
 * Created by root on 28.11.2014.
 */
public class Static_import_Example {
    public static void main(String[] args) {
//        System.out.println(Math.sin(3));
        System.out.println(sin(3));
    }
}
/*
Если мне нужен синус из класса Math, то чтобы вызвать синус (Math.sin(3)) мне приходится обращаться к другому
классу (к библиотеке) Math и тянуть за собой весь этот здоровый класс. Если я не хочу тянуть его за собой, я могу
сделать статический импорт именно того метода, которым я пользуюсь (import static java.lang.Math.sin;) и тягать
за собой только патраха этого метода.
Так можно импортировать методы, поля и классы.
 */