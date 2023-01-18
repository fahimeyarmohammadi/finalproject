package ir.maktab.service;

import ir.maktab.entity.BaseService;
import ir.maktab.entity.Customer;
import ir.maktab.entity.SubService;
import ir.maktab.repository.CustomerRepository;

import java.util.List;

public class CustomerService {

    private final BaseServiceService baseServiceService = BaseServiceService.getInstance();
    private final SubServiceService subServiceService = SubServiceService.getInstance();

    private final CustomerRepository customerRepository = CustomerRepository.getInstance();

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void changePassword(Customer customer){
        customerRepository.update(customer);
    }

    public List<BaseService> getAllBaseService(){
        return baseServiceService.getAllBaseService();
    }

    public List<SubService> getAllSubService(){
        return subServiceService.getAllSubService();
    }

    public List<SubService>getAllSubServiceInBaseService(String baseServiceName){return subServiceService.getAllSubServiceInBaseService(baseServiceName);}


}
