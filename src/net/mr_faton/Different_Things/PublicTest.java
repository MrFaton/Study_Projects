package net.mr_faton.Different_Things;

/**
 * Created by Faton on 16.09.2014.
 */
public class PublicTest {
    public static void main(String[] args) {
        long a=3;
        long b=4;
        System.out.println("a="+a+" b="+b);
        System.out.println(pow(a,b));
    }
    public static long pow (long a, long b){
        if (b==0){
            return 1;
        } else if (b==1){
            return a;
        } else {
            long x=1;
            for (int k=0;k<b;k++){
                x=x*a;
            }
            return x;
        }
    }
}