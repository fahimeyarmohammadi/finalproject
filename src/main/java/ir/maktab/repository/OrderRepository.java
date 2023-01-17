package ir.maktab.repository;

import ir.maktab.entity.Expert;
import ir.maktab.entity.Order;

import javax.persistence.EntityManager;
import java.util.List;

public class OrderRepository implements IRepository<Order>{

    private static final OrderRepository orderRepository = new OrderRepository();

    private OrderRepository() {
    }

    public static OrderRepository getInstance() {
        return orderRepository;
    }
    @Override
    public void save(Order order) {
        EntityManager em = EntityManagerFactoryProducer.emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(order);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Order order) {
        EntityManager em = EntityManagerFactoryProducer.emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(order);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void delete(Order order) {
        EntityManager em = EntityManagerFactoryProducer.emf.createEntityManager();
        em.getTransaction().begin();
        Order deleteOrder = em.find(Order.class, order.getId());
        em.remove(deleteOrder);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public List<Order> getAll() {
        EntityManager em = EntityManagerFactoryProducer.emf.createEntityManager();
        em.getTransaction().begin();
        List<Order> orderList = em.createNamedQuery("getAllOrders").getResultList();
        em.getTransaction().commit();
        em.close();
        return orderList;
    }
}
