package net.mr_faton.OOP.App16_Singleton.SingletonEarly_Pac;

/**
 * Created by root on 02.12.2014.
 */
public class SingletonEarly {
    public static final SingletonEarly instance = new SingletonEarly();/////2

    private SingletonEarly() {/////////////////////////////////////////1
        System.out.println("Hello!, I am one");
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println("Вызываем поле instance, которое создаст синглетон");
        SingletonEarly ref = SingletonEarly.instance;
    }
}
/*
Описание создания:
"1" - делаем конструктор приватным. Следовательно пользоваться этим консруктором можно только в пределах
класса Singleton. И уже из класса Test не получиться создать новый экземпляр синглетона: new Singleton() - так не
получится.

"2" - создаём публичное статическое финальное поле instance. Конструируем экземпляр Singleton() и сохранняем ссылку
на этот экземпляр в поле instance. Это поле должно быть публичным для того чтобы мы погли получить к нему доступ снаружи,
то есть из класса Test. Статическим - потому что нам не нужны экземпляры. Чтобы получить синглетон, ты должен либо
находиться в одном паке с классом Singleton, либо указать ему путь. Поле делается финальным, чтобы враги не смогли
его изменить, например чтобы не сделали так: Singleton.instance = null;
 */