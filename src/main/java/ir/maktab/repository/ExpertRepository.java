package ir.maktab.repository;

import ir.maktab.entity.Customer;
import ir.maktab.entity.Expert;

import javax.persistence.EntityManager;
import java.util.List;

public class ExpertRepository implements IRepository<Expert> {

    private static final ExpertRepository expertRepository = new ExpertRepository();

    private ExpertRepository() {
    }

    public static ExpertRepository getInstance() {
        return expertRepository;
    }

    @Override
    public void save(Expert expert) {

        EntityManager em = EntityManagerFactoryProducer.emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(expert);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void update(Expert expert) {
        EntityManager em = EntityManagerFactoryProducer.emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(expert);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void delete(Expert expert) {

        EntityManager em = EntityManagerFactoryProducer.emf.createEntityManager();
        em.getTransaction().begin();
        Expert deleteExpert = em.find(Expert.class, expert.getId());
        em.remove(deleteExpert);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public List<Expert> getAll() {
        EntityManager em = EntityManagerFactoryProducer.emf.createEntityManager();
        em.getTransaction().begin();
        List<Expert> expertList = em.createNamedQuery("getAllExperts").getResultList();
        em.getTransaction().commit();
        em.close();
        return expertList;
    }
}
