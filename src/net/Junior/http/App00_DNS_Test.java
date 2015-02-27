package net.Junior.http;

import sun.net.spi.nameservice.NameService;
import sun.net.spi.nameservice.dns.DNSNameService;

import java.net.InetAddress;

/**
 * Created by Mr_Faton on 27.02.2015.
 */
public class App00_DNS_Test {
    public static void main(String[] args) throws Exception {
        NameService dns = new DNSNameService();
        InetAddress[] addresses = dns.lookupAllHostAddr("www.google.com.ua");
        //IP адреса, по которым можно попасть на www.google.com.ua
        for (InetAddress address : addresses) {
            System.out.println(address);
        }
        //имена, по которым можно попасть на www.google.com.ua
        System.out.println();
        for (InetAddress address : addresses) {
            System.out.println(dns.getHostByAddr(address.getAddress()));
        }
    }
}
