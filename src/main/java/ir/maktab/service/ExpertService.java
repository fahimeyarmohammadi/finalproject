package ir.maktab.service;

import ir.maktab.entity.BaseService;
import ir.maktab.entity.Expert;
import ir.maktab.entity.SubService;
import ir.maktab.enums.EXPERTCONDITION;
import ir.maktab.exception.NOTFOUNDEXCEPTION;
import ir.maktab.exception.NOVALIDATE;
import ir.maktab.repository.ExpertRepository;
import ir.maktab.util.validation.Validation;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class ExpertService {

    private static final ExpertService expertService = new ExpertService();

    private ExpertService() {
    }

    public static ExpertService getInstance() {
        return expertService;
    }


    private final BaseServiceService baseServiceService = BaseServiceService.getInstance();

    private final SubServiceService subServiceService = SubServiceService.getInstance();

    private final ExpertRepository expertRepository = ExpertRepository.getInstance();

    public void addExpert(Expert expert,String imagePath) throws IOException, NOVALIDATE {

        Validation.validateName(expert.getName());
        Validation.validateName(expert.getFamilyName());
        Validation.validateEmail(expert.getEmail());
        Validation.validatePassword(expert.getPassword());

        expert.setCredit((double) 0);
        expert.setScore(0);
        expert.setExpertcondition(EXPERTCONDITION.valueOf("NEW"));
        expert.setUsername(expert.getEmail());
        expert.setExpertImage(Validation.validateImage(imagePath));
        expertRepository.save(expert);
    }

    public void changPassword(String username, String newPassword) {

        Optional<Expert> optionalExpert = expertRepository.getByUserName(username);
        Expert expert = optionalExpert.orElseThrow(() -> new NOTFOUNDEXCEPTION("Invalid Username"));
        expert.setPassword(newPassword);
        expertRepository.update(expert);
    }


    public Expert signIn(String username, String password) {

        Optional<Expert> optionalExpert = expertRepository.getByUserName(username);
        Expert expert = optionalExpert.orElseThrow(() -> new NOTFOUNDEXCEPTION("Invalid Username"));
        if (!expert.getPassword().equals(password))
            throw new NOTFOUNDEXCEPTION("the password is not correct");
        return expert;
    }

    public Expert getByUsername(String username) {

        Optional<Expert> optionalExpert = expertRepository.getByUserName(username);
        return optionalExpert.orElseThrow(() -> new NOTFOUNDEXCEPTION("Invalid Username"));

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


}
