package ir.maktab.service;

import ir.maktab.entity.BaseService;
import ir.maktab.entity.Customer;
import ir.maktab.entity.Expert;
import ir.maktab.entity.SubService;
import ir.maktab.enums.EXPERTCONDITION;
import ir.maktab.exception.NotFoundException;
import ir.maktab.repository.ExpertRepository;
import ir.maktab.repository.SubServiceRepository;

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

    public void addExpert(Expert expert) {
        expert.setCredit((double) 0);
        expert.setScore(0);
        expert.setExpertcondition(EXPERTCONDITION.valueOf("NEW"));
        expertRepository.save(expert);
    }

    public void changPassword(String email,String newPassword) {
       Expert expert=getExpertByEmail(email);
        expert.setPassword(newPassword);
        expertRepository.update(expert);
    }
    public List<BaseService> getAllBaseService(){
        return baseServiceService.getAllBaseService();
    }

    public List<SubService> getAllSubService(){
        return subServiceService.getAllSubService();
    }

    public List<SubService>getAllSubServiceInBaseService(String baseServiceName){return subServiceService.getAllSubServiceInBaseService(baseServiceName);}

    public Expert signIn(String username, String password) {

        Optional<Expert> optionalExpert = expertRepository.getByUserNameAndPassword(username,password);
        if (optionalExpert.isPresent()) return optionalExpert.get();
        else throw new NotFoundException("expert is null");

    }
    public Expert getExpertByEmail(String email){

        Optional<Expert> optionalExpert = expertRepository.getExpertByEmail(email);
        if (optionalExpert.isPresent()) return optionalExpert.get();
        else throw new NotFoundException("expert is null");
    }

    public void update(Expert expert){
        expertRepository.update(expert);
    }
}
