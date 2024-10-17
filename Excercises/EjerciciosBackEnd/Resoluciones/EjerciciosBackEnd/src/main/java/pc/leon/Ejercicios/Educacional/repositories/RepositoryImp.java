package pc.leon.Ejercicios.Educacional.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import pc.leon.Ejercicios.Educacional.connection.ConnectionManager;
import pc.leon.Ejercicios.Educacional.repositories.interfaces.Repository;

import java.util.List;

public abstract class RepositoryImp<K,L> implements Repository<K,L> {
    protected EntityManager em;

    @Override
    public void add(K entity) {
        em = ConnectionManager.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try{
            transaction.begin();
            em.persist(entity);
            transaction.commit();
        }catch (HibernateException hi){
            if(transaction.isActive()){
                transaction.rollback();
                throw new RuntimeException(hi);
            }
        }finally {
            if(em.isOpen()) em.close();
        }
    }

    @Override
    public void update(K entity) {
        em = ConnectionManager.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try{
            transaction.begin();
            em.merge(entity);
            transaction.commit();
        }catch (HibernateException hi){
            if(transaction.isActive()){
                transaction.rollback();
                throw new RuntimeException(hi);
            }
        }finally {
            if(em.isOpen()) em.close();
        }
    }

    @Override
    public K delete(L entityId) {
        em = ConnectionManager.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try{
            transaction.begin();
            K entity = em.findById();
            transaction.commit();
        }catch (HibernateException hi){
            if(transaction.isActive()){
                transaction.rollback();
                throw new RuntimeException(hi);
            }
        }finally {
            if(em.isOpen()) em.close();
        }
    }

    @Override
    public K findById(L entityId, String className) {
        em = ConnectionManager.getEntityManager();
    }

    @Override
    public List<K> findAll() {
        em = ConnectionManager.getEntityManager();
    }
}
