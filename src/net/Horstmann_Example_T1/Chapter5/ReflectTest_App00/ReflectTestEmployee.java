package net.Horstmann_Example_T1.Chapter5.ReflectTest_App00;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/**
 * Created by Mr_Faton on 26.01.2015.
 */
public class ReflectTestEmployee {
    public static void main(String[] args) {
        //создать объекты класса Employee и передать значения в конструктор
        Employee firstEmployee = new Employee("David", 5.0, 15);
        Employee secondEmployee = new Employee("Emma", 60.0, 30);

        //получить объекты типа Class для объектов firstEmployee и secondEmployee
        Class fstEmClass = firstEmployee.getClass();
        Class secEmClass = secondEmployee.getClass();

        //получить список всех полей, которые есть в классе Employee (так же и приватных полей)
        Field[] fstEmFields = fstEmClass.getDeclaredFields();
        Field[] secEmFields = secEmClass.getDeclaredFields();

        /*
        * это действие позволяет нам открыть доступ ко всем полям (в частности и к приватным), которые есть у класса
        * Employee. Как открыть доступ к одному конкретному полю, смотри Хорстман Т1, стр 256
        * */
        AccessibleObject.setAccessible(fstEmFields, true);
        AccessibleObject.setAccessible(secEmFields, true);

        System.out.println("Первый сотрудник до изменений приватных полей: ");
        //получаем имя и значение всех приватных полей класса Employee и печатаем их
        printEmployee(fstEmFields, firstEmployee);

        System.out.println("\nВторой сотрудник до изменений приватных полей: ");
        //получаем имя и значение всех приватных полей класса Employee и печатаем их
        printEmployee(secEmFields, secondEmployee);

        System.out.println("\nПервый сотрудник полсе изменеий приватных полей:");
        //вызываем метод, который есть в классе Employee, этот метод инкременирует значение своих полей на +5
        firstEmployee.increment();
        printEmployee(fstEmFields, firstEmployee);

        System.out.println("\nВторой сотрудник полсе изменеий приватных полей:");
        //вызываем метод, который есть в классе Employee, этот метод инкременирует значение своих полей на +5
        secondEmployee.increment();
        printEmployee(secEmFields, secondEmployee);

        System.out.println("\nУстановим приватные поля класса Employee вручную, с помощью рефлексии (не используя его внутренний метод increment())");

        System.out.println("\nПервый сотрудник после изменения содержимого поля баланс с помощью рефлексии");
        /*изменяем приватное поле balance класса Employee с помощью рефлексии. Передаём в метод поле,
        *которое хотим изменить. Тут меняем поле balance, в списке оно второе, то есть fstEmFields[1].
        * */
        setBalance(1000, fstEmFields[1], firstEmployee);
        printEmployee(fstEmFields, firstEmployee);

        System.out.println("\nВторой сотрудник после изменения содержимого поля баланс с помощью рефлексии");
        setBalance(2000, secEmFields[1], secondEmployee);
        printEmployee(secEmFields, secondEmployee);


    }

    //метод, которому даёшь список полей и экземпляр класса и он печатает имя и значение поля
    public static void printEmployee(Field[] fields, Employee employee) {
        for (Field field : fields) {
            try {
                System.out.println(field.getName() + ": " + field.get(employee));
            } catch (IllegalAccessException ex) {
                System.out.println("Извини, доступ к полю всётаки закрыт...");
                return;
            }
        }
    }

    //метод, который устанавливает значение конкредного приватного поля с помощью рефлексии
    public static void setBalance(int value, Field field, Employee employee) {
        try {
            field.set(employee, value);
        } catch (IllegalAccessException e) {
            System.out.println("Доступ к полю закрыт");
            return;
        }
    }
}