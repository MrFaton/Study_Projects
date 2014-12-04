package net.mr_faton.OOP.App19_Overloading.App07;

/**
 * Created by Faton on 04.12.2014.
 */
public class App07 {
    public static void main(String[] args) {
        //Вызываем наш ОВЕРЛОАД метод
        new App07().equals(new App07());

        //Теперь вызовем наш ОВЕРРАЙД метод
        new App07().equals((Object) new App07());
    }


    //    @Override//Это вертикальный оверлоадинг. Поэтому компилятор запрещает нам написать @Override. И мы совершенно не перекрываем метод equals, который есть у Object и как следствие этого у нас 2 метода equals - один у предка, другой у моего класса
    public boolean equals(App07 that) {
        System.out.println("Hello. This is OVERLOAD method equals");
        return false;
    }

    @Override
//Просто пример для сравнения. Это уже настоящщий оверрайд метод, которым мы перекрыли метод, который есть у нашего предка - Object-а
    public boolean equals(Object obj) {
        System.out.println("Hello. I am OVERRIDE method equals");
        return false;
    }
}
/*
В нашем примере вертикальный оверлоадинг получился благодаря тому, что у нас отличаются аргументы у наших методов equals.
equals, который есть у Object-а требует в аргументе Object, т.е. - public boolean equals(Object obj).
Наш класс App07 создал метод с такой же сигнатурой, но другим аргументом - public boolean equals(App07 that).
Поэтому в классе App07 существует 2 разных метода equals просто с одинаковым именем (один equals от Object, другой
equals от нашего класса App07).

Внизу, самый последний equals является оверрайд методом, он просто приведен для сравнения.
 */