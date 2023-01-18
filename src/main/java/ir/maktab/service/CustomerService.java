package ir.maktab.service;

import ir.maktab.entity.BaseService;
import ir.maktab.entity.Customer;
import ir.maktab.entity.Expert;
import ir.maktab.entity.SubService;
import ir.maktab.exception.NotFoundException;
import ir.maktab.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

public class CustomerService {

    private final BaseServiceService baseServiceService = BaseServiceService.getInstance();

    private final SubServiceService subServiceService = SubServiceService.getInstance();

    private final CustomerRepository customerRepository = CustomerRepository.getInstance();

    private final OrderService orderService = OrderService.getInstance();

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void changPassword(String email,String newPassword) {

        Customer customer=getCustomerByEmail(email);
        customer.setPassword(newPassword);
        customerRepository.update(customer);
    }

    public List<BaseService> getAllBaseService(){
        return baseServiceService.getAllBaseService();
    }

    public List<SubService> getAllSubService(){
        return subServiceService.getAllSubService();
    }

    public List<SubService>getAllSubServiceInBaseService(String baseServiceName){return subServiceService.getAllSubServiceInBaseService(baseServiceName);}

    public Customer signIn(String username, String password) {

        Optional<Customer> optionalCustomer = customerRepository.getByUserNameAndPassword(username,password);
        if (optionalCustomer.isPresent()) return optionalCustomer.get();
        else throw new NotFoundException("customer is null");
    }
    public Customer getCustomerByEmail(String email){

        Optional<Customer> optionalCustomer = customerRepository.getCustomerByEmail(email);
        if (optionalCustomer.isPresent()) return optionalCustomer.get();
        else throw new NotFoundException("customer is null");
    }

}
