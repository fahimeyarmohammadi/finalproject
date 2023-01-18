package ir.maktab.service;

import ir.maktab.entity.BaseService;
import ir.maktab.exception.NotFoundException;
import ir.maktab.exception.OBJECTISEXIST;
import ir.maktab.repository.BaseServiceRepository;

import java.util.List;
import java.util.Optional;

public class BaseServiceService {

    private static final BaseServiceService baseServiceService = new BaseServiceService();

    private BaseServiceService() {
    }

    public static BaseServiceService getInstance() {
        return baseServiceService;
    }

    private final BaseServiceRepository baseServiceRepository = BaseServiceRepository.getInstance();

    public void addBaseService(BaseService baseService) throws OBJECTISEXIST {
        if (baseServiceRepository.getBaseServiceByName(baseService.getName()).isPresent())
            throw new OBJECTISEXIST("this baseService is existing");
        else
            baseServiceRepository.save(baseService);
    }

    public List<BaseService> getAllBaseService() {
       return  baseServiceRepository.getAll();
    }

    public Optional<BaseService> getBaseServiceByName(String baseServiceName){
        return baseServiceRepository.getBaseServiceByName(baseServiceName);
    }
}
