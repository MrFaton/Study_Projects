package net.mr_faton.Different_Things;

import java.io.File;
import java.net.URISyntaxException;

public class RootWorkinDir {
    public static void main(String[] args) throws URISyntaxException {
        System.out.println(new File(RootWorkinDir.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()));
    }
}
/*
Узнать корневую рабочую папку для проекта или jar файла
 */