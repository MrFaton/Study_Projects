package net.mr_faton.Different_Things;

import java.io.IOException;

public class OpenFileInNeedProgramm {
    public static void main(String[] args) throws InterruptedException, IOException {
        String img = "c:\\test\\w.bmp";
        String prog = "C:\\Program Files\\Paint.NET\\PaintDotNet.exe";
        new ProcessBuilder(prog, img).start();
    }
}

