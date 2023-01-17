package ir.maktab.service;

import ir.maktab.entity.BaseService;
import ir.maktab.entity.SubService;

public class ManagerService {
    private final BaseServiceService baseServiceService = BaseServiceService.getInstance();
    private final SubServiceService subServiceService = SubServiceService.getInstance();

    public void addBaseService(BaseService baseService){

        baseServiceService.addBaseService(baseService);
    }

    public void getAllBaseService(){
        baseServiceService.getAllBaseService();
    }

    public void getAllSubService(){
        subServiceService.getAllSubService();
    }

    public void addSubService(SubService subService){
        subServiceService.addSubService(subService);
    }

}
