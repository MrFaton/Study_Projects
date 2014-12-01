package net.mr_faton.OOP.App15_Listener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Faton on 30.11.2014.
 */
public class RadioButton implements MouseListener, Clicked {
    private int myX;
    private int myY;
    private boolean on = false;

    public RadioButton(int myX, int myY) {
        this.myX = myX;
        this.myY = myY;
        Mouse.addListener(this);
    }

    List<Clicked> isClicked = new ArrayList<>();

    @Override
    public void mouseClicked(int x, int y) {
        if (((myX - x) * (myX - x) + (myY - y) * (myY - y)) < 10 * 10) {
            on = true;
            for (Clicked clickedListener : isClicked) {
                clickedListener.imClicked();
            }
        }
    }

    public void addClickedListener(Clicked clickedListener) {
        isClicked.add(clickedListener);
    }

    public boolean getOn() {
        return on;
    }

    @Override
    public void imClicked() {
        on = false;
    }
}