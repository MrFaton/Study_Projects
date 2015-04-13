package net.mr_faton.Different_Things;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class OpenFileByAnotherProgramm {
    public static void main(String[] args) throws InterruptedException, IOException {
        File img = new File("c:\\test\\w.bmp");
        Desktop.getDesktop().open(img);
    }
}

