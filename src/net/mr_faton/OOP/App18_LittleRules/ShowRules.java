package net.mr_faton.OOP.App18_LittleRules;

/**
 * Created by Faton on 03.12.2014.
 */

class ClassDemo {
    //    abstract void f();//тут не может быть абстрактного метода
    void f1() {
    }//так можно, потому что у нас конкретный метод, просто он ничего не делает

    void g() {
    }//методы q() и w() имеют совершенно разную область видимости. q()-имеет дефолтную область (package private), то есть q() видно либо моему наследнику, либо тому, кто рядом со мной в пакете, а w() - только private (видно только внутри скобок класса)

    public void w() {
    }
}

abstract class AbstractClassDemo {
    abstract void f();

    void g() {
    }
}

interface InterfaceDemo {
    abstract void f();//в интерфейсе все методы обязаны быть абстактными, а так же все они автоматически public

    void f1();//даже если мы не добавили слово abstract, то метод f1() всё равно считается абстрактным
//    void  f2() {}//прикрутить тело НЕ выйдет, так как метод интерфейса не может содержать тело

    void q();//метод q() и w() объявлены одинаково (с одинаковой областью видимости public), то есть они оба public abstract, только в методе q() это будет добавлено автоматически комплилятором

    public abstract void w();
}


public class ShowRules {
    public static void main(String[] args) {
        new ClassDemo();//экземпляры класса создавать можно
//        new AbstractClassDemo();//экземпляры абстрактного класса создавать НЕльзя
//        new InterfaceDemo();//экземпляры интерфейса создавать НЕльзя
    }
}
