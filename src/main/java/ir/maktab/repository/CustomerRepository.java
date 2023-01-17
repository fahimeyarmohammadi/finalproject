package ir.maktab.repository;

import ir.maktab.entity.Customer;

import javax.persistence.EntityManager;
import java.util.List;

public class CustomerRepository implements IRepository<Customer>{

    private static final CustomerRepository customerRepository = new CustomerRepository();

    private CustomerRepository() {
    }

    public static CustomerRepository getInstance() {
        return customerRepository;
    }

    public void save(Customer customer) {
            EntityManager em = EntityManagerFactoryProducer.emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();
            em.close();
    }

    public void update(Customer customer) {
        EntityManager em = EntityManagerFactoryProducer.emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(customer);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Customer customer) {
        EntityManager em = EntityManagerFactoryProducer.emf.createEntityManager();
        em.getTransaction().begin();
        Customer deleteCustomer = em.find(Customer.class, customer.getId());
        em.remove(deleteCustomer);
        em.getTransaction().commit();
        em.close();
    }

    public List<Customer> getAll() {
        EntityManager em = EntityManagerFactoryProducer.emf.createEntityManager();
        em.getTransaction().begin();
        List<Customer> customerList = em.createNamedQuery("getAllCustomers").getResultList();
        em.getTransaction().commit();
        em.close();
        return customerList;
    }
}
