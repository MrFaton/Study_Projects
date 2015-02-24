package net.mr_faton.Different_Things.LittleChat2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Mr_Faton on 25.02.2015.
 */
class Server1 {
    public void start() throws IOException {
        ServerSocket server = new ServerSocket(5000);
        Socket client = server.accept();
        PrintWriter writer = new PrintWriter(client.getOutputStream());
        writer.println("Hello");
        writer.flush();
        writer.close();
    }
}
public class Server {
    public static void main(String[] args) throws IOException {
        new Server1().start();
    }
}