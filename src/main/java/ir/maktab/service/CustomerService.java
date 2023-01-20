package ir.maktab.service;

import ir.maktab.entity.BaseService;
import ir.maktab.entity.Customer;
import ir.maktab.entity.CustomerOrder;
import ir.maktab.entity.SubService;
import ir.maktab.exception.NOVALIDATE;
import ir.maktab.exception.NOTFOUNDEXCEPTION;
import ir.maktab.repository.CustomerRepository;
import ir.maktab.util.validation.Validation;

import java.util.List;
import java.util.Optional;

public class CustomerService {

    private static final CustomerService customerService = new CustomerService();

    private CustomerService() {
    }

    public static CustomerService getInstance() {
        return customerService;
    }


    private final CustomerRepository customerRepository = CustomerRepository.getInstance();

    private final CustomerOrderService orderService = CustomerOrderService.getInstance();

    private final BaseServiceService baseServiceService=BaseServiceService.getInstance();

    private final SubServiceService subServiceService=SubServiceService.getInstance();

    public void addCustomer(Customer customer) throws NOVALIDATE {

        Validation.validateName(customer.getName());
        Validation.validateName(customer.getFamilyName());
        Validation.validateEmail(customer.getEmail());
        Validation.validatePassword(customer.getPassword());
        customer.setCredit((double) 0);
        customer.setUsername(customer.getEmail());
        customerRepository.save(customer);

    }

    public void changPassword(String username, String newPassword) {

        Optional<Customer> signInCustomer = customerRepository.getByUserName(username);
        Customer customer = signInCustomer.orElseThrow(() -> new NOTFOUNDEXCEPTION("Invalid Username"));
        customer.setPassword(newPassword);
        customerRepository.update(customer);

    }

    public Customer signIn(String username, String password) {

        Optional<Customer> signInCustomer = customerRepository.getByUserName(username);
        Customer customer = signInCustomer.orElseThrow(() -> new NOTFOUNDEXCEPTION("Invalid Username"));
        if (!customer.getPassword().equals(password))
            throw new NOTFOUNDEXCEPTION("the password is not correct");
        return customer;

    }

    public void customerGetOrder(CustomerOrder order) throws NOVALIDATE {

        orderService.addOrder(order);

    }

    public List<BaseService> getAllBaseService() {
        return baseServiceService.getAllBaseService();
    }

    public List<SubService> getAllSubServiceInBaseService(String baseServiceName) {

        return subServiceService.getAllSubServiceInBaseService(baseServiceName);

    }

}
