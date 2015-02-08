package net.Horstmann_Example_T2.Chapter1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Mr_Faton on 08.02.2015.
 */
public class App08_RegExp_Simple {
    public static void main(String[] args) {
        String text = "<a href=/quality.html>Качество</a></li>\n" +
                "а теперь просто строка\n" +
                "<div id=\"guestbook_link\"><a href='http://expogas.net/guestbook.html'>Гостевая книга</a></div>\n" +
                "a href=";

        String regExp = "(.*href\\s*=\\s*)(.*?)>";
        Pattern pattern = Pattern.compile(regExp, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
//            int start = matcher.start();
//            int end = matcher.end();
//            String match = text.substring(start, end);
//            System.out.println(match);

            System.out.println(matcher.group(2));
        }
    }
}
/*
Шаблоны:
[...] - любой символ указынный в скобках, так же может использоваться диапазоны символов (напр: [a-z])
[^...] - Любой из символов, что не указан в скобках.
. -Любой символ, кроме перевода строки.
? - Предыдущий шаблон не обязателен
+ - Одно и более повторений.
* - Ноль или более повторений.
*? - Ноль или больше (нежадный)
+? - 1 или больше (нажадный)
?? - 0 или 1 (нежадный)
{3,5} - 3, 4 и 5 повторений
{3,5}? - 3, 4 и 5 повторений (наежадный)
(...) - скобки указывают группу выражений, потом к этой группе можно обращаться и печатать её, получать её как отдельную
подстроку
 */