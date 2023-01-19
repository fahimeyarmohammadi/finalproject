package ir.maktab.repository;

import ir.maktab.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class CustomerRepository implements IRepository<Customer> {

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

    public Optional<Customer> getByUserName(String username) {

        Customer customer;
        try {
            EntityManager em = EntityManagerFactoryProducer.emf.createEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery("from Customer c where c.username =:username");
            query.setParameter("username", username);
            customer = (Customer) query.getSingleResult();
            customer.getOrderList().size();
            em.getTransaction().commit();
            em.close();
        } catch (NoResultException e) {
            customer = null;
        }
        return Optional.ofNullable(customer);
    }
}

