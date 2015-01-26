package net.Horstmann_Example_T1.Chapter5;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Created by Mr_Faton on 26.01.2015.
 */
public class ReflectTest {
    public static void main(String[] args) {
        System.out.println("Введи полное имя класса (Н: java.lang.Integer):");

        Scanner in = new Scanner(System.in);
        String inputName = in.next();

        Class cl = null;
        try {
            cl = Class.forName(inputName);
        } catch (ClassNotFoundException ex) {
            System.out.println("Класс не найден...");
            System.exit(0);
        }

        if (cl == null) {
            System.out.println("Ссылка на объект Class == null. Работа завершена...");
            System.exit(0);
        }

        printGeneral(cl);
        System.out.println("\n{");

        System.out.println("  Констукторы:");
        printConstructors(cl);

        System.out.println("\n  Методы:");
        printMethods(cl);

        System.out.println("\n  Поля:");
        printFields(cl);

        System.out.println("}");
    }

    //печатает модификаторы класса, имя класса, имя класса-предка, интерфейсы
    public static void printGeneral(Class cl) {
        //печатаем модификаторы класса (публичный, финальный и т.д.)
        String modifires = Modifier.toString(cl.getModifiers());
        if (modifires.length() > 0) System.out.print(modifires + " ");

        //печатаем имя класса
        String name = cl.getName();
        System.out.print(name + " ");

        //печатем имя класса-предка
        Class superCl = cl.getSuperclass();
        if (superCl != null && superCl != Object.class) {
            String superClName = superCl.getName();
            System.out.print("extends " + superClName + " ");
        }

        //печатем интерфейсы
        Class[] interfaces = cl.getInterfaces();
        System.out.print("implements ");
        for (int i = 0; i < interfaces.length; i++) {
            if (i > 0) {
                System.out.println(", ");
            }
            System.out.print(interfaces[i].getName());
        }
    }

    //печатает конструкторы
    public static void printConstructors(Class cl) {
        //получить список конструкторов
        Constructor[] constructors = cl.getConstructors();
        for (Constructor constructor : constructors) {
            //получить модификаторы констуктора
            String modifires = Modifier.toString(constructor.getModifiers());
            //получить имя конструктора
            String constructorName = constructor.getName();
            //печать модификаторы + имя
            System.out.print("  " + modifires + " " + constructorName + "(");
            //получить принемаемые параметры конструктора
            Class[] parameters = constructor.getParameterTypes();
            //печать принемаехы параметров
            for (int x = 0; x < parameters.length; x++) {
                if (x > 0) {
                    System.out.print(", ");
                }
                System.out.print(parameters[x].getName());
            }
            System.out.println(");");
        }
    }

    //печатае все методы, доступные в классе (методы, которые достались по наследству не отображаются)
    public static void printMethods(Class cl) {
        //получить список всех методов в классе
        Method[] methods = cl.getDeclaredMethods();

        for (Method method : methods) {
            //получить модификаторы метода
            String modifiers = Modifier.toString(method.getModifiers());
            //получить возвращаемый методом тим
            Class returnType = method.getReturnType();
            String returnTypeName = returnType.getName();
            //получить имя метода
            String nameOfMethod = method.getName();
            //распечатать модификаторы + возвращаемое значение + имя
            System.out.print("  " + modifiers + " " + returnTypeName + " " + nameOfMethod + "(");
            // получить параметры, получаемые методом
            Class[] parameters = method.getParameterTypes();
            //печать параметров
            for (int x = 0; x < parameters.length; x++) {
                if (x > 0) {
                    System.out.print(", ");
                }
                System.out.print(parameters[x]);
            }
            System.out.println(");");
        }
    }

    //печатает все поля, которые есть в классе
    public static void printFields(Class cl) {
        //получить все поля класса
        Field[] fields = cl.getFields();
        //обработать каждое поле класса
        for (Field field : fields) {
            //получить модификаторы поля
            String modifiers = Modifier.toString(field.getModifiers());
            //получить тип поля
            Class typeOfField = field.getType();
            String typeOfFieldName = typeOfField.getName();
            //получить имя поля
            String fieldName = field.getName();
            //распечатать модификаторы + тип поля + имя поля
            System.out.println("  " + modifiers + " " + typeOfFieldName + " " + fieldName + ";");
        }
    }
}
