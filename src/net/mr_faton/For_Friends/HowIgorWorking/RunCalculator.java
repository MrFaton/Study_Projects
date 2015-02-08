package net.mr_faton.For_Friends.HowIgorWorking;

/**
 * Created by Faton on 04.12.2014.
 */
public class RunCalculator {
    public static void main(String[] args) {
        //Необходимую дату нужно ввести в методе calculateDay в формате: день, месяц, год.
        System.out.println(new Calculator().calculateDay(05, 02, 2015));
    }
}
