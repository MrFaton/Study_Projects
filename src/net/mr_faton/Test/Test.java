package net.mr_faton.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        UserSes userSes = new UserSes();
        userSes.map.put("hi", 1);
        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             ObjectOutputStream objectOutput = new ObjectOutputStream(out)) {

            objectOutput.writeObject(userSes);
            objectOutput.flush();

            byte[] bytes = out.toByteArray();
            System.out.println(Arrays.toString(bytes));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

class UserSes implements Serializable {
    public Map<Object, Integer> map = new LinkedHashMap<>();
}