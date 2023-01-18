package ir.maktab.service;

import ir.maktab.entity.BaseService;
import ir.maktab.entity.Expert;
import ir.maktab.entity.SubService;
import ir.maktab.repository.ExpertRepository;

import java.util.List;

public class ExpertService {

    private final BaseServiceService baseServiceService = BaseServiceService.getInstance();
    private final SubServiceService subServiceService = SubServiceService.getInstance();

    private final ExpertRepository expertRepository = ExpertRepository.getInstance();

    public void addExpert(Expert expert) {
        expertRepository.save(expert);
    }

    public void changPassword(Expert expert) {
        expertRepository.update(expert);
    }
    public List<BaseService> getAllBaseService(){
        return baseServiceService.getAllBaseService();
    }

    public List<SubService> getAllSubService(){
        return subServiceService.getAllSubService();
    }

    public List<SubService>getAllSubServiceInBaseService(String baseServiceName){return subServiceService.getAllSubServiceInBaseService(baseServiceName);}

}
