package net.mr_faton.Different_Things;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ConvertPNG_to_BMP {
    public static void main(String[] args) throws InterruptedException, IOException {
        File imgFile = new File("c:\\test\\q.png");
        BufferedImage bufferedImage = ImageIO.read(imgFile);
        File outImg = new File("c:\\test\\w.bmp");
        ImageIO.write(bufferedImage, "bmp", outImg);
    }
}

