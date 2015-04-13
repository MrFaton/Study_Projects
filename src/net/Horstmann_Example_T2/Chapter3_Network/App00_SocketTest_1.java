package net.Horstmann_Example_T2.Chapter3_Network;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Mr_Faton on 18.02.2015.
 */
public class App00_SocketTest_1 {
    public static void main(String[] args) {
        try (Socket socket = new Socket()) {
//            socket.connect(new InetSocketAddress("time-A.timefreq.bldrdoc.gov", 13), 5000);
            socket.connect(new InetSocketAddress("horstmann.com", 80), 5000);
            socket.setSoTimeout(10000);
            InputStream inputStream = socket.getInputStream();
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
