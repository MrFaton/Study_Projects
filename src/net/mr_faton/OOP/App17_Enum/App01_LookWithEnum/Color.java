package net.mr_faton.OOP.App17_Enum.App01_LookWithEnum;

/**
 * Created by Faton on 03.12.2014.
 */
public enum Color {
    RED, GREEN, BLUE;
}

class ColoredRect {
    private int w;
    private int h;
    private Color color;

    ColoredRect(int w, int h, Color color) {
        this.w = w;
        this.h = h;
        this.color = color;
    }
}

class Test {
    public static void main(String[] args) {
        new ColoredRect(10, 25, Color.GREEN);
//        new ColoredRect(10, Color.GREEN, Color.RED);//так уже сделать не получится, потому что мы уже типизировали наши поля. w и h - требует int, а color уже требует класс Color
    }
}