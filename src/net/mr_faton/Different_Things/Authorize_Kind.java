package net.mr_faton.Different_Things;

import java.util.Base64;

/**
 * Created by root on 20.03.2015.
 */
public class Authorize_Kind {
    public static void main(String[] args) {
        Base64.Encoder encoder = Base64.getEncoder();
        String str = "kharmet:9NCzR##?3z";
        String encodedStr = encoder.encodeToString(str.getBytes());
        System.out.println(encodedStr);
    }
}
