package net.mr_faton.Different_Things;

import java.io.IOException;

/**
 * Created by root on 26.08.2014.
 */
public class SystemIn_App {
    public static void main(String[] args) throws IOException {
        while (true) {
            int ch = System.in.read();
            System.out.print((char) ch);
            System.out.println((char) ch);
        }
    }
}
