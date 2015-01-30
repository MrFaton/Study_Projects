package net.Horstmann_Example_T1.Chapter11;

/**
 * Created by Mr_Faton on 30.01.2015.
 */
public class App00_Exception0 {
    public static void main(String[] args) {
        try {
            a();
        } catch (Exception e) {
            StackTraceElement[] frames = e.getStackTrace();
            for (StackTraceElement frame : frames) {
                System.out.println(frame);
            }
        }
    }

    public static void a() throws Exception {
        System.out.println("Entry -> A");
        System.out.println("Method A");
        b();
        System.out.println("<- Exit A");
    }

    public static void b() throws Exception {
        System.out.println("Entry B ->");
        System.out.println("Method B");
        c();
        System.out.println("<- Exit B");
    }

    public static void c() throws Exception {
        System.out.println("Entry C ->");
        System.out.println("Method C");
        throw new Exception("Созданная ошибка");
    }
}
