package net.mr_faton.OOP.App13_Inner_classes.App01_Pac;

/**
 * Created by Faton on 28.11.2014.
 */
public class App01 {
    public class Inner {
    }
}

class Test {
    public static void main(String[] args) {
        App01 ref0 = new App01();//создали экземпляр outer класса, объемлющего класса
//        App01.Inner ref1 = new App01.Inner();//не работает, потому что экземпляр inner класса ниначто не ссылается, а так быть не может
        App01.Inner ref1 = ref0.new Inner();//работает, потому что теперь inner класс может ссылаться на экземпляр outer класса. Тут мы имеем ссылку на объемлюющий класс, а также ссылку на Inner класс

        App01.Inner ref2 = ref0.new Inner();//можно создавать много inner-ов, которые имеют ссылку на одного outer-а
        App01.Inner ref3 = ref0.new Inner();
        App01.Inner ref4 = ref0.new Inner();

        App01.Inner ref5 = new App01().new Inner();//тоже самое, только более короткая запись, только тут мы не имеем ссылку на outer/объемлюющий класс, но от всё равно жив и висит в Heap-е потому что на него есть ссылка
    }
}