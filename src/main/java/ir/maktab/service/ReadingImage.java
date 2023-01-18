package ir.maktab.service;

import ir.maktab.exception.NOVALIDATE;
import ir.maktab.exception.NotFoundException;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class ReadingImage {

    public static byte[] readImage(String imagePath) throws NOVALIDATE {

        File file = new File(imagePath);
        byte[] data = new byte[0];

        ImageInputStream imageInputStream = null;
        try {
            imageInputStream = ImageIO.createImageInputStream(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // get all currently registered readers that recognize the image format

        Iterator<ImageReader> iter = ImageIO.getImageReaders(imageInputStream);

        if (!iter.hasNext()) {

            throw new RuntimeException("No readers found!");

        }

        // get the first reader

        ImageReader reader = iter.next();

        try {
            if (!reader.getFormatName().equals("jpg")) {
                throw new NOVALIDATE("the image format must be JPG");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (file.exists()) {
            double imageSize = file.length();
            double imageSIzeInKb = (imageSize / 1024);
            if (imageSIzeInKb > 300) {
                throw new NOVALIDATE("image size must be less than 300 kb");
            } else
                try {
                    BufferedImage myPicture = ImageIO.read(file);
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    ImageIO.write(myPicture, "jpg", bos);
                    data = bos.toByteArray();


                } catch (IOException e) {
                    e.printStackTrace();
                }
        }else
    {
        throw new NotFoundException("File does not exists!");
    }

        return data;
}
}

