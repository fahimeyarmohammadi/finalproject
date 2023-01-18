package ir.maktab.repository;

import ir.maktab.entity.Customer;

import javax.persistence.EntityManager;
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

    public Optional<Customer> getByUserNameAndPassword(String username, String password) {
        Optional<Customer> customer;
        EntityManager em = EntityManagerFactoryProducer.emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("from Customer c where c.username =:username and c.password =:password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        customer = (Optional<Customer>) query.getSingleResult();
        em.getTransaction().commit();
        em.close();
        return customer;
    }

    public Optional<Customer> getCustomerByEmail(String email){
        Optional<Customer> customer;
        EntityManager em = EntityManagerFactoryProducer.emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("from Customer c where c.email=:email");
        query.setParameter("email",email);
        customer = (Optional<Customer>) query.getSingleResult();
        em.getTransaction().commit();
        em.close();
        return customer;
    }
}

