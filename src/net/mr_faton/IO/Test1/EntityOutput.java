package net.mr_faton.IO.Test1;

import java.io.IOException;

/**
 * Created by root on 13.10.2014.
 */
public interface EntityOutput {
    public void writePerson(Person person) throws IOException;
    public void writePoint(Point point) throws IOException;
}
