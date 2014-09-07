package net.mr_faton.exceptions;

/**
 * Created by root on 07.09.2014.
 */
public class App09 {
    public static void main(String[] args) throws Exception {
        try {
            try {
                throw new Error();
            } catch (Error e) {
                throw new RuntimeException(e);
            }
        } catch (RuntimeException x){
            throw new Exception(x);
        }
    }
}
//Сломались мы по Exception, первая строка в логе: "Exception in thread "main" java.lang.Exception: java.lang.RuntimeException: java.lang.Error",
//потм в логе в строке "Caused by" указывается причина по которой было вызвано перове исключение: "Caused by: java.lang.RuntimeException: java.lang.Error",
//потом снова в строке "Caused by" указывается причина по которой было вызвано предыдущее исключение: "Caused by: java.lang.Error",
// то есть, из лога видно (смотреть снизу в верх), что сначала мы сломалиь по Error, затем по RuntimeException и потом уже по Exception