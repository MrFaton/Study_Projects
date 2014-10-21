package net.mr_faton.Different_Things;

/**
 * Created by root on 21.10.2014.
 */
public class CompareTest {
    public static void main(String[] args) {
        System.out.println("A".compareTo("B") > 0);//возвращает -1, т.к. А не равно В, оно больше (первее) В и при сравнении -1>0 возвращает false
        System.out.println("A".compareTo("B") < 0);//возвращает -1, т.к. А не равно В, оно больше (первее) В и при сравнении -1<0 возвращает true
    }
}
