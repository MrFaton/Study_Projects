package net.mr_faton.OOP.App09_VirtualMethod;

/**
 * Created by Faton on 26.11.2014.
 */
public class Figure {
    public int centrX, centrY;

    public int left() {
        throw new UnsupportedOperationException("boooom");
    }
}
