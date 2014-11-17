package net.mr_faton.OOP;

/**
 * Created by Faton on 17.11.2014.
 */
public class App06 {
    public static void main(String[] args) {
        fun(new int[] {5, 10, 15}, 1);
        fun("Hello!", 0);
    }

    public static void fun(int[] myArray, int index){
        System.out.println(myArray[index]);
    }

    public static void fun (String str, int index){
        System.out.println(str.charAt(index));
    }
}
/*Это хороший стиль ООП через оверлоадинг методов. Это ещё удобно тем, что проверка типов проводится ещё в момент
компиляции. Теперь компилятор не даст возможность пользователю передать в мой метод fun какой-нибудь другой объект,
например это "fun(new Object(), 0);" компилятор сразу зарежет
 */