package ir.maktab.service;

import ir.maktab.entity.Customer;
import ir.maktab.entity.CustomerOrder;
import ir.maktab.exception.NOVALIDATE;
import ir.maktab.exception.NOTFOUNDEXEPTION;
import ir.maktab.repository.CustomerRepository;

import java.util.Optional;

public class CustomerService {

    private static final CustomerService customerService = new CustomerService();

    private CustomerService() {
    }

    public static CustomerService getInstance() {
        return customerService;
    }


    private final CustomerRepository customerRepository = CustomerRepository.getInstance();

    private final OrderService orderService = OrderService.getInstance();

    public void addCustomer(Customer customer) {

        customer.setCredit((double) 0);
        customer.setUsername(customer.getEmail());
        customerRepository.save(customer);
    }

    public void changPassword(String username, String newPassword) {

        Optional<Customer> signInCustomer = customerRepository.getByUserName(username);
        Customer customer = signInCustomer.orElseThrow(() -> new NOTFOUNDEXEPTION("Invalid Username"));
        customer.setPassword(newPassword);
        customerRepository.update(customer);
    }

    public Customer signIn(String username, String password) {

        Optional<Customer> signInCustomer = customerRepository.getByUserName(username);
        Customer customer = signInCustomer.orElseThrow(() -> new NOTFOUNDEXEPTION("Invalid Username"));
        if (!customer.getPassword().equals(password))
            throw new NOTFOUNDEXEPTION("the password is not correct");
        return customer;
    }

    public void customerGetOrder(CustomerOrder order) throws NOVALIDATE {

        orderService.addOrder(order);
    }
}
