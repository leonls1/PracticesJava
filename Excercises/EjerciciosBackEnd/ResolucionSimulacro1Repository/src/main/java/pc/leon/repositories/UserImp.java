package pc.leon.repositories;

import org.hibernate.HibernateException;
import pc.leon.entities.Language;
import pc.leon.entities.Tag;
import pc.leon.entities.User;
import pc.leon.repositories.context.DBContext;
import pc.leon.repositories.interfaces.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserImp implements UserRepository {
    DBContext context = DBContext.getInstance();
    EntityManager em;

    @Override
    public void create(User user) {
        getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            if(existByName(user.getName())){
                em.merge(user);
            }else {
                em.persist(user);
            }
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            closingEm();
        }
    }

    @Override
    public void update(User user) {
        getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(user);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (em.isOpen() && em != null) {
                em.close();
            }
        }
    }

    @Override
    public User findById(Long id) {
        getEntityManager();
        User user = em.find(User.class, id);
        closingEm();
        return user;
    }

    @Override
    public List<User> findAll() {
        getEntityManager();
        TypedQuery query = em.createQuery("select l from User l",User.class);
        List<User> list = query.getResultList();
        closingEm();
        return list;
    }

    @Override
    public User delete(Long id) {
        getEntityManager();
        if (existsById(id)) {
            EntityTransaction transaction = em.getTransaction();
            User user = findById(id);
            try {
                transaction.begin();
                em.remove(user);
                transaction.commit();
            } catch (HibernateException e) {
                transaction.rollback();
                throw new RuntimeException(e);
            } finally {
                closingEm();
            }
            return user;
        }
        return null;
    }

    @Override
    public boolean existsById(Long id) {
        getEntityManager();
        User user = em.find(User.class, id);
        closingEm();
        return (user != null);
    }

    private void getEntityManager() {
        this.em = context.getEm();
    }

    private void closingEm(){
        if (em.isOpen() && em != null) {
            em.close();
        }
    }
    private boolean existByName(String userName ) {
        getEntityManager();
        try {
            TypedQuery<User> query = em.createQuery("SELECT r FROM User r WHERE r.name = :name", User.class);
            query.setParameter("name", userName);
            // Retorna true si se encuentra un resultado
            query.getSingleResult(); // Si no hay resultados, lanzará NoResultException
            return true;
        } catch (NoResultException e) {
            // Si no se encuentra un resultado, retornamos false
            return false;
        } finally {
            closingEm();
        }
    }

    private User findTagByName(String userName){
        getEntityManager();
        try {
            TypedQuery<User> query = em.createQuery("SELECT r FROM User r WHERE r.name = :name", User.class);
            query.setParameter("name", userName);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            closingEm();
        }
    }
}
