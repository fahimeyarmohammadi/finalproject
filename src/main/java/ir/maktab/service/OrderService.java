package ir.maktab.service;

public class OrderService {
    private static final OrderService orderService = new OrderService();

    private OrderService() {
    }

    public static OrderService getInstance() {
        return orderService;
    }
}
