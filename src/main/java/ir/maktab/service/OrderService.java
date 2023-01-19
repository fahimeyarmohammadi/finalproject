package ir.maktab.service;

import ir.maktab.entity.CustomerOrder;
import ir.maktab.enums.ORDERCONDITION;
import ir.maktab.exception.NOVALIDATE;
import ir.maktab.repository.OrderRepository;
import ir.maktab.util.DateUtil;

import java.time.LocalDateTime;

public class OrderService {

    private static final OrderService orderService = new OrderService();

    private OrderService() {
    }

    public static OrderService getInstance() {
        return orderService;
    }


    private final OrderRepository orderRepository = OrderRepository.getInstance();

    public void addOrder(CustomerOrder order) throws NOVALIDATE {

        if (order.getProposedPrice() < order.getSubService().getBasePrice()) {
            throw new NOVALIDATE("the proposedPrice must greater than subServer basePrice");
        } else if (DateUtil.dateToLocalDateTime(order.getPreferDate()).isBefore(LocalDateTime.now())) {
            throw new NOVALIDATE("prefer Date must be after now");
        } else
            order.setOrdercondition(ORDERCONDITION.valueOf("WAITINGFORTHESUGGESTINOFEXPERT"));
        orderRepository.save(order);
    }
}
