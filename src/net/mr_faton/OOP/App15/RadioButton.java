package net.mr_faton.OOP.App15;

/**
 * Created by Faton on 30.11.2014.
 */
public class RadioButton implements MouseListener {
    private int myX;
    private int myY;
    private boolean on = false;

    public RadioButton(int myX, int myY) {
        this.myX = myX;
        this.myY = myY;
    }

    @Override
    public void mouseClicked(int x, int y) {
        if (((myX - x) * (myX - x) + (myY - y) * (myY - y)) < 10 * 10) {
            on = true;
        }
    }

    public boolean getOn() {
        return on;
    }
}