package ir.maktab;

import ir.maktab.entity.Customer;
import ir.maktab.service.CustomerService;

public class Main {
    public static void main(String[] args) {
        CustomerService customerService=CustomerService.getInstance();

        System.out.println("hello");
        Customer customer=new Customer();
        customer.setName("fahime");
        customer.setFamilyName("yari");
        customer.setPassword("12fahime");
        customer.setEmail("fahimeyarmohammadi@yahoo.com");
        customerService.addCustomer(customer);
        System.out.println(customerService.getCustomerByEmail("fahimeyarmohammadi@yahoo.com"));





    }
}
