package net.mr_faton.OOP.App17_Enum.App00_OldLook;

/**
 * Created by Faton on 03.12.2014.
 */
public class Color {
    public static final int RED = 0;
    public static final int GREEN = 1;
    public static final int BLUE = 2;
}

class ColoredRect {
    private int w;
    private int h;
    private int color;

    ColoredRect(int w, int h, int color) {
        this.w = w;
        this.h = h;
        this.color = color;
    }
}

class Test {
    public static void main(String[] args) {
        new ColoredRect(12, 20, Color.GREEN);
        new ColoredRect(12, Color.RED, 234);//вот в этом проблема. Никто не мешал так делать.
    }
}