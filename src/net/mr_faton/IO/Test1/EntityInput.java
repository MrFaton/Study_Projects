package net.mr_faton.IO.Test1;

import java.io.IOException;

/**
 * Created by root on 13.10.2014.
 */
public interface EntityInput {
    public Person readPerson() throws IOException;

    public Point readPoint() throws IOException;
}
