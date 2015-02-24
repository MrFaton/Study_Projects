package net.mr_faton.Different_Things.LittleChat2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by Mr_Faton on 25.02.2015.
 */
class Client1 {
    public void start() throws IOException {
        Socket client = new Socket("127.0.0.1", 5000);
        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        System.out.println(reader.readLine());
    }
}

public class Client {
    public static void main(String[] args) throws IOException {
        new Client1().start();
    }
}