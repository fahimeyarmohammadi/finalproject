package ir.maktab.service;

import ir.maktab.entity.SubService;
import ir.maktab.exception.NotFoundException;
import ir.maktab.exception.OBJECTISEXIST;
import ir.maktab.repository.SubServiceRepository;

import java.util.List;

public class SubServiceService {
    private final BaseServiceService baseServiceService = BaseServiceService.getInstance();
    private static final SubServiceService subServiceService = new SubServiceService();

    private SubServiceService() {
    }

    public static SubServiceService getInstance() {
        return subServiceService;
    }

    private final SubServiceRepository subServiceRepository = SubServiceRepository.getInstance();

    public void addSubService(SubService subService) throws OBJECTISEXIST {

        if (!baseServiceService.getBaseServiceByName(subService.getName()).isPresent())
            throw new NotFoundException("this baseService is not exist");
        else if (subServiceRepository.getSubServiceByName(subService.getSubName()).isPresent())
            throw new OBJECTISEXIST("this subService is exist");
        else
            subServiceRepository.save(subService);
    }

    public List<SubService> getAllSubService() {
        return subServiceRepository.getAll();
    }

    public List<SubService> getAllSubServiceInBaseService(String baseServiceName) {
        if (baseServiceService.getBaseServiceByName(baseServiceName).isPresent())
            return subServiceRepository.getAllSubServiceInBaseService(baseServiceName);
        else
            throw new NotFoundException("this baseService is not exist");
    }


    public void update(SubService subService) {
        subServiceRepository.update(subService);
    }
}
