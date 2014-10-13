package net.mr_faton.IO.Test1;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by root on 13.10.2014.
 */
public class EntityOutputStream implements EntityOutput {
    private final DataOutput out;

    public EntityOutputStream(OutputStream out) {
        this.out = new DataOutputStream(out);
    }

    @Override
    public void writePerson(Person person) throws IOException {
        out.writeInt(person.getAge());
        if (person.getName()==null){
            out.writeBoolean(false);
        } else {
            out.writeBoolean(true);
            out.writeUTF(person.getName());
        }
    }

    @Override
    public void writePoint(Point point) throws IOException {
        int value=point.getX()<<4|point.getY();
        out.writeByte(value);
    }
}
