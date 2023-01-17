package ir.maktab.service;

import ir.maktab.entity.BaseService;
import ir.maktab.entity.SubService;
import ir.maktab.repository.BaseServiceRepository;
import ir.maktab.repository.SubServiceRepository;

public class SubServiceService {

    private static final SubServiceService subServiceService = new SubServiceService();

    private SubServiceService() {
    }

    public static SubServiceService getInstance() {
        return subServiceService;
    }

    private final SubServiceRepository subServiceRepository = SubServiceRepository.getInstance();

    public void addSubService(SubService subService) {

        subServiceRepository.save(subService);
    }

    public void getAllSubService(){
        subServiceRepository.getAll();
    }

    public void update(SubService subService){
        subServiceRepository.update(subService);
    }
}
