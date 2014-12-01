package net.mr_faton.OOP.App15_Listener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Faton on 30.11.2014.
 */
public class Mouse {
    static private List<MouseListener> listeners = new ArrayList<>();

    static public void addListener(MouseListener listener) {
        listeners.add(listener);
    }

    static public void click(int x, int y) {
        for (MouseListener listener : listeners) {
            listener.mouseClicked(x, y);
        }
    }
}
