package ir.maktab.repository;

import ir.maktab.entity.CustomerOrder;

import javax.persistence.EntityManager;
import java.util.List;

public class OrderRepository implements IRepository<CustomerOrder>{

    private static final OrderRepository orderRepository = new OrderRepository();

    private OrderRepository() {
    }

    public static OrderRepository getInstance() {
        return orderRepository;
    }
    @Override
    public void save(CustomerOrder order) {
        EntityManager em = EntityManagerFactoryProducer.emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(order);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(CustomerOrder order) {
        EntityManager em = EntityManagerFactoryProducer.emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(order);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void delete(CustomerOrder order) {
        EntityManager em = EntityManagerFactoryProducer.emf.createEntityManager();
        em.getTransaction().begin();
        CustomerOrder deleteOrder = em.find(CustomerOrder.class, order.getId());
        em.remove(deleteOrder);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public List<CustomerOrder> getAll() {
        EntityManager em = EntityManagerFactoryProducer.emf.createEntityManager();
        em.getTransaction().begin();
        List<CustomerOrder> orderList = em.createNamedQuery("getAllOrders").getResultList();
        em.getTransaction().commit();
        em.close();
        return orderList;
    }
}
