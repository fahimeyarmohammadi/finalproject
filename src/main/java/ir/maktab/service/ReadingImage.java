package ir.maktab.service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ReadingImage {

    public ReadingImage() throws IOException {
    }

    String imagePath = "path/to/your/image.jpg";
    BufferedImage myPicture = ImageIO.read(new File(imagePath));




}

