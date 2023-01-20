package ir.maktab.service;

import ir.maktab.entity.BaseService;
import ir.maktab.entity.Expert;
import ir.maktab.entity.SubService;
import ir.maktab.enums.EXPERTCONDITION;
import ir.maktab.exception.NOTFOUNDEXEPTION;
import ir.maktab.exception.NOVALIDATE;
import ir.maktab.repository.ExpertRepository;
import ir.maktab.repository.SubServiceRepository;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class ExpertService {

    private static final ExpertService expertService = new ExpertService();

    private ExpertService() {
    }

    public static ExpertService getInstance() {
        return expertService;
    }

    private final SubServiceRepository subServiceRepository = SubServiceRepository.getInstance();

    private final BaseServiceService baseServiceService = BaseServiceService.getInstance();

    private final SubServiceService subServiceService = SubServiceService.getInstance();

    private final ExpertRepository expertRepository = ExpertRepository.getInstance();

    public void addExpert(Expert expert) throws IOException, NOVALIDATE {

        expert.setCredit((double) 0);
        expert.setScore(0);
        expert.setExpertcondition(EXPERTCONDITION.valueOf("NEW"));
        expert.setUsername(expert.getEmail());
        expert.setExpertImage(readImage());
        expertRepository.save(expert);
    }

    public void changPassword(String username, String newPassword) throws NOVALIDATE, IOException {

        Optional<Expert> optionalExpert = expertRepository.getByUserName(username);
        Expert expert = optionalExpert.orElseThrow(() -> new NOTFOUNDEXEPTION("Invalid Username"));
        expert.setPassword(newPassword);
        expert.setExpertImage(readImage());
        expertRepository.update(expert);
    }


    public Expert signIn(String username, String password) {

        Optional<Expert> optionalExpert = expertRepository.getByUserName(username);
        Expert expert = optionalExpert.orElseThrow(() -> new NOTFOUNDEXEPTION("Invalid Username"));
        if (!expert.getPassword().equals(password))
            throw new NOTFOUNDEXEPTION("the password is not correct");
        return expert;
    }

    public Expert getByUsername(String username) {
        Optional<Expert> optionalExpert = expertRepository.getByUserName(username);
        Expert expert = optionalExpert.orElseThrow(() -> new NOTFOUNDEXEPTION("Invalid Username"));
        return expert;
    }

    public List<BaseService> getAllBaseService() {
        return baseServiceService.getAllBaseService();
    }

    public List<SubService> getAllSubServiceInBaseService(String baseServiceName) {
        return subServiceService.getAllSubServiceInBaseService(baseServiceName);
    }

    public void update(Expert expert) {
        expertRepository.update(expert);
    }

    public static byte[] readImage() throws IOException, NOVALIDATE {

        //size validation
        File file = new File("aaa.jpg");
        double imageSize = file.length();
        double imageSIzeInKb = (imageSize / 1024);
        if (imageSIzeInKb > 300) {
            throw new NOVALIDATE("image size must be less than 300 kb");
        }

        //validat format
        ImageInputStream iis = ImageIO.createImageInputStream(file);
        Iterator<ImageReader> imageReaders = ImageIO.getImageReaders(iis);
        String format = new String();

        while (imageReaders.hasNext()) {
            ImageReader reader = (ImageReader) imageReaders.next();
            format = reader.getFormatName();
        }
        if (format.equals("jpg")) {
            throw new NOVALIDATE("the image format must be JPEG");
        }

        //reading file
        BufferedImage bImage = ImageIO.read(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bImage, "jpg", bos);
        byte[] data = bos.toByteArray();

        return data;
    }
}
