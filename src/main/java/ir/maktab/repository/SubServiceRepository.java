package ir.maktab.repository;

import ir.maktab.entity.SubService;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class SubServiceRepository implements IRepository<SubService> {

    private static final SubServiceRepository subServiceRepository = new SubServiceRepository();

    private SubServiceRepository() {
    }

    public static SubServiceRepository getInstance() {
        return subServiceRepository;
    }

    @Override
    public void save(SubService subService) {

        EntityManager em = EntityManagerFactoryProducer.emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(subService);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void update(SubService subService) {

        EntityManager em = EntityManagerFactoryProducer.emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(subService);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void delete(SubService subService) {

        EntityManager em = EntityManagerFactoryProducer.emf.createEntityManager();
        em.getTransaction().begin();
        SubService deleteSubService = em.find(SubService.class, subService.getId());
        em.remove(deleteSubService);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public List<SubService> getAll() {

        EntityManager em = EntityManagerFactoryProducer.emf.createEntityManager();
        em.getTransaction().begin();
        List<SubService> subServiceList = (List<SubService>) em.createNamedQuery("getAllSubServices").getResultList();
        em.getTransaction().commit();
        em.close();
        return subServiceList;

    }

    public List<SubService> getAllSubServiceInBaseService(String name) {

        EntityManager em = EntityManagerFactoryProducer.emf.createEntityManager();
        em.getTransaction().begin();
        List<SubService> subServiceList = (List<SubService>) em.createNamedQuery("getAllSubServicesByBaseServiceName").setParameter("name", name).getResultList();
        em.getTransaction().commit();
        em.close();
        return subServiceList;

    }

    public Optional<SubService> getSubServiceByName(String subName) {

        SubService subService;
        try {
            EntityManager em = EntityManagerFactoryProducer.emf.createEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery("from SubService s where s.subName=:subName");
            query.setParameter("subName", subName);
            subService = (SubService) query.getSingleResult();
            em.getTransaction().commit();
            em.close();
        }catch (NoResultException e) {
            subService = null;
        }
        return Optional.ofNullable(subService);

    }
}