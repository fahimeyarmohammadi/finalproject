package ir.maktab.repository;

import ir.maktab.entity.BaseService;
import ir.maktab.entity.SubService;
import ir.maktab.repository.IRepository;

import javax.persistence.EntityManager;
import java.util.List;

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
       SubService deleteSubService= em.find(SubService.class, subService.getId());
        em.remove(deleteSubService);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public List<SubService> getAll() {
        EntityManager em = EntityManagerFactoryProducer.emf.createEntityManager();
        em.getTransaction().begin();
        List<SubService> subServiceList = em.createNamedQuery("getAllSubServices").getResultList();
        em.getTransaction().commit();
        em.close();
        return subServiceList;
    }
}
