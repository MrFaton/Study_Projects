package net.mr_faton.IO;

/**
 * Created by Faton on 16.09.2014.
 */
public class App00 {
    public static void main(String[] args) throws Exception {
        byte[] bytes0 = {70, 71, 72, 73};
        String str0 = new String(bytes0, "UTF-8");
        System.out.println(str0);
        char[] chars = str0.toCharArray();
        System.out.println(chars[0]); //здесь говорится системе, что нужно вывести глиф, который соответсвует чару с номером инта 70 в правиле UTF-8
        System.out.println(chars[1]);
        System.out.println(chars[2]);
        System.out.println(chars[3]);
        System.out.println(chars[3] + 0);// здесь получается, что мы уже не оперируем типом char, а перешли на тип int
        System.out.println((int) chars[3]);//тоже самое что и выше, только тут принудительно переобразуем тип char в int
        System.out.println(chars[3]);

        String str1 = new String(bytes0, "cp1251");
        System.out.println(str1);//хотя используем разные кодировки (правила), но выводит одни и те же символы, потому что у UTF-8 и cp1251 первые 127 символом совпадают. Если загуглить ASCII table (ASCII - кодировка, которая была ещё до Unicode), то в таблице будут видны все эти значения, т.е. чему соответствует char[70]=F
        byte[] bb = {};
        String str2 = new String(bb, "Unicode");
        System.out.println(str2);


    }
}
