package net.Junior.jsf.app00_simple;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

@ManagedBean
@RequestScoped
public class Greeting implements Serializable{
    private String text1 = "default input";
    private String text2;
    private int number;
    private IntegerPair intPair;

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public IntegerPair getIntPair() {
        return intPair;
    }

    public void setIntPair(IntegerPair intPair) {
        this.intPair = intPair;
    }

    @Override
    public String toString() {
        return "text1=" + text1 + "\n" +
                "text2=" + text2 + "\n" +
                "number=" + number + "\n" +
                "intPair=" + intPair;
    }
}
