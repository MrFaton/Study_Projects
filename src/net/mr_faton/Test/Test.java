package net.mr_faton.Test;



public class Test {
    public static void main(String[] args) {
        Thread th = new Thread(new Thread(){
            public void run (){
                System.out.println("Hello");
            }
        });
        th.start();
    }
}