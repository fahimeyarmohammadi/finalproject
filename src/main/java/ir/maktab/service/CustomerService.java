package ir.maktab.service;

import ir.maktab.entity.Customer;
import ir.maktab.repository.CustomerRepository;

public class CustomerService {

    private final CustomerRepository customerRepository = CustomerRepository.getInstance();

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

}
