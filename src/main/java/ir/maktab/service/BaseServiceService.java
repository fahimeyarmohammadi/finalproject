package ir.maktab.service;

import ir.maktab.entity.BaseService;
import ir.maktab.repository.BaseServiceRepository;

public class BaseServiceService {

    private static final BaseServiceService baseServiceService = new BaseServiceService();

    private BaseServiceService() {
    }

    public static BaseServiceService getInstance() {
        return baseServiceService;
    }

    private final BaseServiceRepository baseServiceRepository = BaseServiceRepository.getInstance();

    public void addBaseService(BaseService baseService) {


        baseServiceRepository.save(baseService);
    }

    public void getAllBaseService(){
        baseServiceRepository.getAll();
    }

}
