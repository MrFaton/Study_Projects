package net.mr_faton.Different_Things.ContetnFinder_InFsTo;

import java.util.Objects;

/**
 * Created by root on 10.02.2015.
 */
public class Content implements Comparable<Content> {
    public final String name;
    public final int positive;
    public final int negative;

    public Content(String name, int positive, int negative) {
        this.name = name;
        this.positive = positive;
        this.negative = negative;
    }

    @Override
    public int compareTo(Content otherContent) {
        return Integer.compare(otherContent.positive, positive);
    }

    @Override
    public boolean equals(Object otherObj) {
        if (otherObj == null) return false;
        if (otherObj.getClass() != this.getClass()) return false;
        Content other = (Content) otherObj;
        return name.equals(other.name) && positive == other.positive && negative == other.negative;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name + positive + negative);
    }

    @Override
    public String toString() {
        return name + " = " + positive + " положительных; " + negative + " отрицательных";
    }
}