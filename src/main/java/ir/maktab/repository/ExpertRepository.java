package ir.maktab.repository;

import ir.maktab.entity.Customer;
import ir.maktab.entity.Expert;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

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

    public Optional<Expert> getByUserNameAndPassword(String username, String password) {
        Optional<Expert> expert;
        EntityManager em = EntityManagerFactoryProducer.emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("from Expert e where e.username =:username and e.password =:password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        expert = (Optional<Expert>) query.getSingleResult();
        em.getTransaction().commit();
        em.close();
        return expert;
    }

    public List<Expert> getExpertNotAccepted(){
        List<Expert>expertList;
        EntityManager em = EntityManagerFactoryProducer.emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("from Expert e where e.expertcondition=:NEW or e.expertcondition=:AWAITINGCONFIRMATION");
        expertList=query.getResultList();
        em.getTransaction().commit();
        em.close();
        return expertList;
    }

    public Optional<Expert> getExpertByEmail(String email){
        Optional<Expert> expert;
        EntityManager em = EntityManagerFactoryProducer.emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("from Expert e where e.email=:email");
        query.setParameter("email",email);
        expert = (Optional<Expert>) query.getSingleResult();
        em.getTransaction().commit();
        em.close();
        return expert;
    }
}
