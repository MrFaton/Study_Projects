package net.mr_faton.Different_Things.ContetnFinder_InFsTo;

/**
 * Created by root on 10.02.2015.
 */
public class Page implements Comparable<Page> {
    public final String name;
    public final int positiveVotes;
    public final int negativeVotes;

    public Page(String name, int positiveVotes, int negativeVotes) {
        this.name = name;
        this.positiveVotes = positiveVotes;
        this.negativeVotes = negativeVotes;
    }
    @Override
    public int compareTo(Page otherPage) {
        return Integer.compare(positiveVotes, otherPage.positiveVotes);
    }
    @Override
    public String toString() {
        return name + " | " + positiveVotes + " положительных | " + negativeVotes + " отрицательных";
    }
}
