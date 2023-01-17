package ir.maktab.repository;

import ir.maktab.entity.BaseService;
import ir.maktab.entity.Expert;

import javax.persistence.EntityManager;
import java.util.List;

public class BaseServiceRepository implements IRepository<BaseService>{

    private static final BaseServiceRepository baseServiceRepository = new BaseServiceRepository();

    private BaseServiceRepository() {
    }

    public static BaseServiceRepository getInstance() {
        return baseServiceRepository;
    }
    @Override
    public void save(BaseService baseService) {
        EntityManager em = EntityManagerFactoryProducer.emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(baseService);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(BaseService baseService) {
        EntityManager em = EntityManagerFactoryProducer.emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(baseService);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void delete(BaseService baseService) {
        EntityManager em = EntityManagerFactoryProducer.emf.createEntityManager();
        em.getTransaction().begin();
        BaseService deleteBaseService= em.find(BaseService.class, baseService.getId());
        em.remove(deleteBaseService);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<BaseService> getAll() {
        EntityManager em = EntityManagerFactoryProducer.emf.createEntityManager();
        em.getTransaction().begin();
        List<BaseService> baseServiceList = em.createNamedQuery("getAllBaseServices").getResultList();
        em.getTransaction().commit();
        em.close();
        return baseServiceList;
    }
}
