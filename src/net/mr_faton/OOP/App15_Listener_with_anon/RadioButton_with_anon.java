package net.mr_faton.OOP.App15_Listener_with_anon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Faton on 30.11.2014.
 */
public class RadioButton_with_anon implements Clicked {
    private int myX;
    private int myY;
    private boolean on = false;

    public RadioButton_with_anon(int newX, int newY) {
        this.myX = newX;
        this.myY = newY;
        Mouse.addListener(new MouseListener() {
            @Override
            public void mouseClicked(int x, int y) {
                if (((myX - x) * (myX - x) + (myY - y) * (myY - y)) < 10 * 10) {
                    on = true;
                    for (Clicked clickedListener : isClicked) {
                        clickedListener.imClicked();
                    }
                }
            }
        });
    }

    List<Clicked> isClicked = new ArrayList<>();

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