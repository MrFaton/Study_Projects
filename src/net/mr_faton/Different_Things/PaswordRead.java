package net.mr_faton.Different_Things;


import java.io.Console;

/**
 * Created by root on 21.01.2015.
 */
public class PaswordRead {
    public static void main(String[] args) {
        Console console = System.console();
        if (console == null) {
            System.exit(-1);
        }
        String user = console.readLine("User name: ");
        char[] password = console.readPassword("Password: ");

        System.out.println("User: " + user + " Password: " + password);
    }
}
