package ir.maktab.service;

import ir.maktab.entity.BaseService;

public class ManagerService {
    private final BaseServiceService baseServiceService = BaseServiceService.getInstance();

    public void addBaseService(BaseService baseService){
        baseServiceService.addBaseService(baseService);
    }

    public void getAllBaseService(){
        baseServiceService.getAllBaseService();
    }

}
