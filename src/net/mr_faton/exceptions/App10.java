package net.mr_faton.exceptions;

/**
 * Created by root on 07.09.2014.
 */
public class App10 {
    public static void main(String[] args) {
        try {
            try {
                throw new Error();
            } catch (Error e) {
                throw new RuntimeException(e);
            }
        } catch (RuntimeException x){
            System.out.println(x);
            System.out.println(x.getCause());
            System.out.println(x.getCause().getCause());
        }
    }
}
//лететь может только одно исключение, но мы бросили новое и как "приклеяли" к нему старое исключение. Таки склеянные исключения
//похожы на двусвязные списки (Node), метод getCause(), наследуемый от Throwable, как бы прыгает к следующему исключению в списке,
//таким образом можно понять с какого исключения начался сбой.
