package ir.maktab.service;

import ir.maktab.entity.SubService;
import ir.maktab.exception.NOTFOUNDEXEPTION;
import ir.maktab.exception.OBJECTISEXIST;
import ir.maktab.repository.SubServiceRepository;

import java.util.List;
import java.util.Optional;

public class SubServiceService {

    private static final SubServiceService subServiceService = new SubServiceService();

    private SubServiceService() {
    }

    public static SubServiceService getInstance() {
        return subServiceService;
    }

    private final BaseServiceService baseServiceService = BaseServiceService.getInstance();

    private final SubServiceRepository subServiceRepository = SubServiceRepository.getInstance();

    public void addSubService(SubService subService) throws OBJECTISEXIST {

        if (!baseServiceService.getBaseServiceByName(subService.getBaseService().getName()).isPresent())

            throw new NOTFOUNDEXEPTION("this baseService is not exist");

        else
        {
            for (SubService s:subServiceRepository.getAllSubServiceInBaseService(subService.getBaseService().getName())) {
                if (s.getSubName().equals(subService.getSubName()))
                    throw new OBJECTISEXIST("this subService is exist");
            }
        }
            subServiceRepository.save(subService);
    }

    public List<SubService> getAllSubService() {
        return subServiceRepository.getAll();
    }

    public List<SubService> getAllSubServiceInBaseService(String baseServiceName) {

        if (baseServiceService.getBaseServiceByName(baseServiceName).isPresent())
            return subServiceRepository.getAllSubServiceInBaseService(baseServiceName);
        else
            throw new NOTFOUNDEXEPTION("this baseService is not exist");
    }

    public SubService getSubServiceByName(String subName) {

        Optional<SubService> optionalSubService = subServiceRepository.getSubServiceByName(subName);
        if (optionalSubService.isPresent()) return optionalSubService.get();
        else throw new NOTFOUNDEXEPTION("SubService not sound");
    }


    public void changeSubServiceBasePrice(String subName, Double newPrice) {
        SubService subService = subServiceService.getSubServiceByName(subName);
        subService.setBasePrice(Double.valueOf(newPrice));
        subServiceRepository.update(subService);
    }

    public void changeSubServiceDescription(String subName, String newDescription) {
        SubService subService = subServiceService.getSubServiceByName(subName);
        subService.setDescription(newDescription);
        subServiceRepository.update(subService);
    }
}
