package ir.maktab.service;

import ir.maktab.entity.BaseService;
import ir.maktab.entity.Expert;
import ir.maktab.entity.SubService;
import ir.maktab.enums.EXPERTCONDITION;
import ir.maktab.exception.OBJECTISEXIST;

import java.util.List;

public class ManagerService {

    private final BaseServiceService baseServiceService = BaseServiceService.getInstance();
    private final SubServiceService subServiceService = SubServiceService.getInstance();
    private final ExpertService expertService=ExpertService.getInstance();

    public void addBaseService(BaseService baseService) throws OBJECTISEXIST {

        baseServiceService.addBaseService(baseService);
    }

    public List<BaseService> getAllBaseService() {
        return baseServiceService.getAllBaseService();
    }

    public List<SubService> getAllSubService() {
        return subServiceService.getAllSubService();
    }

    public List<SubService> getAllSubServiceInBaseService(String baseServiceName) {
        return subServiceService.getAllSubServiceInBaseService(baseServiceName);
    }

    public void addSubService(SubService subService) throws OBJECTISEXIST {
        subServiceService.addSubService(subService);
    }

    public void acceptExpert(String expertEmail){
        Expert expert=expertService.getExpertByEmail(expertEmail);
        expert.setExpertcondition(EXPERTCONDITION.valueOf("ACCEPTED"));
        expertService.update(expert);
    }

    public void addExpertToSubService(String expertEmail,String subServiceName){


    }
}