package net.mr_faton.Different_Things;


import java.io.Console;

/**
 * Created by root on 21.01.2015.
 */
public class PasswordRead {
    public static void main(String[] args) {
        Console con = System.console();
        if (con == null) {
            System.out.print("Couldn't instance console...");
            System.exit(0);
        }
        String user = con.readLine("User name: ");
        char[] pass = con.readPassword("Password: ");

        System.out.println("User name is: " + user + " password is: " + pass);
    }
}
/*
В IDEA можно не запускать, потому что через идею нельзя получить в руки консоль. Этот код необходимо запускать изпод
консоли.
 */