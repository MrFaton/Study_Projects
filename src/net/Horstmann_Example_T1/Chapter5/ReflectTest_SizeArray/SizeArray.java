package net.Horstmann_Example_T1.Chapter5.ReflectTest_SizeArray;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Mr_Faton on 26.01.2015.
 */
public class SizeArray {
    public static void main(String[] args) {
        //создаём массив
        int[] arrInt = {1, 2, 3};
        //печатаем массив
        System.out.println("До\nРазмер: " + arrInt.length + " Содержимое: " + Arrays.toString(arrInt));
        //передаём массив методу и увеличиваем его с 3-х до 5-ти элементов и приводим его к типу нужного массива
        arrInt = (int[]) sizeArray(arrInt, 5);
        //печатаем массив
        System.out.println("После\nРазмер: " + arrInt.length + " Содержимое: " + Arrays.toString(arrInt));

        System.out.println();

        String[] arrStr = {"Привет", "Погода", "Замечательно", "Тренажёрка"};
        System.out.println("До\nРазмер: " + arrStr.length + " Содержимое: " + Arrays.toString(arrStr));
        arrStr = (String[]) sizeArray(arrStr, 3);
        System.out.println("После\nРазмер: " + arrStr.length + " Содержимое: " + Arrays.toString(arrStr));
    }

    public static Object sizeArray(Object oldArray, int length) {
        //получаем объект типа Class для переданного нам массива
        Class oldArrayClass = oldArray.getClass();
        //проверяем это массив или нет
        if (!oldArrayClass.isArray()) {
            return null;
        }
        //получаем тип нашего массива (Int, String или ещё что-нибудь)
        Class componentType = oldArrayClass.getComponentType();
        //получаем длину старого массива. Статический метод Array.getLength может определить длину любого массива
        int lengthOfOldArray = Array.getLength(oldArray);
        //создаём новый масси такого же типа как нам и передали и такой длины, как нам передали, но ссылаемся мы на новый массив с помощью ссылки типа Object
        Object newArray = Array.newInstance(componentType, length);
        System.arraycopy(oldArray, 0, newArray, 0, Math.min(lengthOfOldArray, length));
        return newArray;
    }
}
//Метод sizeArray способен увеличить или уменьшить любой массив (массив любого типа) при помощи рефлексии