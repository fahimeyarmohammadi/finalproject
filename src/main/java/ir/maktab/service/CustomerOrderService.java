package ir.maktab.service;

import ir.maktab.entity.CustomerOrder;
import ir.maktab.enums.ORDERCONDITION;
import ir.maktab.exception.NOVALIDATE;
import ir.maktab.repository.CustomerOrderRepository;
import ir.maktab.util.DateUtil;

import java.time.LocalDateTime;

public class CustomerOrderService {

    private static final CustomerOrderService orderService = new CustomerOrderService();

    private CustomerOrderService() {
    }

    public static CustomerOrderService getInstance() {
        return orderService;
    }


    private final CustomerOrderRepository orderRepository = CustomerOrderRepository.getInstance();

    public void addOrder(CustomerOrder order) throws NOVALIDATE {

        if (order.getProposedPrice() < order.getSubService().getBasePrice()) {
            throw new NOVALIDATE("the proposedPrice must greater than subServer basePrice");
        } else if (DateUtil.dateToLocalDateTime(order.getPreferDate()).isBefore(LocalDateTime.now())) {
            throw new NOVALIDATE("prefer Date must be after now");
        } else if (order.getAddress() == null)
            throw new NOVALIDATE("you must have an address");

        order.setOrdercondition(ORDERCONDITION.valueOf("WAITINGFORTHESUGGESTINOFEXPERT"));

        orderRepository.save(order);

    }

}