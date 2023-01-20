package ir.maktab;

import ir.maktab.entity.*;
import ir.maktab.exception.NOVALIDATE;
import ir.maktab.exception.OBJECTISEXIST;
import ir.maktab.repository.OrderRepository;
import ir.maktab.service.*;
import ir.maktab.util.DateUtil;

import java.io.IOException;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws NOVALIDATE, OBJECTISEXIST, IOException {
        CustomerService customerService=CustomerService.getInstance();
        OrderRepository orderRepository=OrderRepository.getInstance();
        BaseServiceService baseServiceService=BaseServiceService.getInstance();
        SubServiceService subServiceService=SubServiceService.getInstance();
        ManagerService managerService=ManagerService.getInstance();
        ExpertService expertService=ExpertService.getInstance();

        System.out.println("hello");
        Customer customer=new Customer();
        customer.setName("fahime");
        customer.setFamilyName("yari");
        customer.setPassword("Fahime12");
        customer.setEmail("fahimeyarmohammadi@yahoo.com");
       customerService.addCustomer(customer);


//        BaseService baseService=new BaseService();
//        baseService.setName("HomeAppliances");
//        managerService.addBaseService(baseService);
//
//        SubService subService=new SubService();
//        subService.setBaseService(baseService);
//        subService.setBasePrice(20e3);
//        subService.setSubName("Kitchen appliances");
//        managerService.addSubService(subService);

  //      System.out.println(managerService.getAllSubServiceInBaseService("HomeAppliances"));






//        CustomerOrder order=new CustomerOrder();
//        order.setProposedPrice(23e4);
//        order.setDescription("nezafat");
//        order.setSubService(subService);
//        LocalDateTime localDateTime1 =
//                LocalDateTime.of(2024, 03, 28, 14, 33, 48, 640000);
//
//        order.setPreferDate(DateUtil.localDateTimeToDate(localDateTime1));
//
//        customerService.customerGetOrder(order);

//        Expert expert=new Expert();
//        expert.setName("somaye");
//        expert.setFamilyName("karimi");
//        expert.setPassword("1234somi");
//        expert.setEmail("somaye@yahoo.com");
//        expertService.addExpert(expert,"aaa.jpg");

    //    managerService.acceptExpert("somaye@yahoo.com");



//        managerService.addExpertToSubService("somaye@yahoo.com","Kitchen appliances");
//        Expert expert1=expertService.getByUsername("somaye@yahoo.com");
//
//        subServiceService.changeSubServiceDescription("Kitchen appliances","alaki");











    }
}
