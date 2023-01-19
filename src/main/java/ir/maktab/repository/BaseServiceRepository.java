package ir.maktab.repository;

import ir.maktab.entity.BaseService;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class BaseServiceRepository implements IRepository<BaseService> {

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
        BaseService deleteBaseService = em.find(BaseService.class, baseService.getId());
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

    public Optional<BaseService> getBaseServiceByName(String name) {

        BaseService baseService;
        try {
            EntityManager em = EntityManagerFactoryProducer.emf.createEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery("from BaseService b where b.name=:name");
            query.setParameter("name", name);
            baseService = (BaseService) query.getSingleResult();
            em.getTransaction().commit();
            em.close();
        }catch (NoResultException e) {
            baseService = null;
        }
        return Optional.ofNullable(baseService);
    }

}
