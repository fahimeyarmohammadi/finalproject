package ir.maktab.service;

import ir.maktab.entity.BaseService;
import ir.maktab.entity.SubService;
import ir.maktab.exception.OBJECTISEXIST;

import java.util.List;

public class ManagerService {

    private final BaseServiceService baseServiceService = BaseServiceService.getInstance();
    private final SubServiceService subServiceService = SubServiceService.getInstance();

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

}
