package net.Horstmann_Example_T2.Chapter3_Network;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * Created by Mr_Faton on 07.04.2015.
 */
public class App01_InetAddress_00 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("twitter.com");
        byte[] addressBytes = address.getAddress();
        System.out.println(Arrays.toString(addressBytes));
        System.out.println(address);
    }
}
