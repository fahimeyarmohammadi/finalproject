package ir.maktab.service;

import ir.maktab.entity.Order;
import ir.maktab.exception.NOVALIDATE;
import ir.maktab.repository.OrderRepository;

import java.util.Date;

public class OrderService {

    private static final OrderService orderService = new OrderService();

    private OrderService() {
    }

    public static OrderService getInstance() {
        return orderService;
    }


    private final OrderRepository orderRepository = OrderRepository.getInstance();

    public void addOrder(Order order) throws NOVALIDATE {

        if (order.getProposedPrice() < order.getSubService().getBasePrice()) {
            throw new NOVALIDATE("the proposedPrice must greater than subServer basePrice");
        } else if (order.getPreferDate().before(new Date())) {
            throw new NOVALIDATE("prefer Date must be after now");
        } else
            orderRepository.save(order);
    }
}
