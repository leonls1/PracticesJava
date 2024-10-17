package pc.leon.repositories;

import org.hibernate.HibernateException;
import pc.leon.entities.Language;
import pc.leon.entities.Tag;
import pc.leon.repositories.context.DBContext;
import pc.leon.repositories.interfaces.TagRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class TagImp implements TagRepository {
    DBContext context = DBContext.getInstance();
    EntityManager em;

    @Override
    public void create(Tag tag) {
        getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            if(existByName(tag.getName())){
                em.merge(tag);
            }else {
                em.persist(tag);
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
    public void update(Tag tag) {
        getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(tag);
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
    public Tag findById(Long id) {
        getEntityManager();
        Tag tag = em.find(Tag.class, id);
        closingEm();
        return tag;
    }

    @Override
    public List<Tag> findAll() {
        getEntityManager();
        TypedQuery query = em.createQuery("select l from Tag l",Tag.class);
        List<Tag> list = query.getResultList();
        closingEm();
        return list;
    }

    @Override
    public Tag delete(Long id) {
        getEntityManager();
        if (existsById(id)) {
            EntityTransaction transaction = em.getTransaction();
            Tag tag = findById(id);
            try {
                transaction.begin();
                em.remove(tag);
                transaction.commit();
            } catch (HibernateException e) {
                transaction.rollback();
                throw new RuntimeException(e);
            } finally {
                closingEm();
            }
            return tag;
        }
        return null;
    }

    @Override
    public boolean existsById(Long id) {
        getEntityManager();
        Tag tag = em.find(Tag.class, id);
        closingEm();
        return (tag != null);
    }

    private void getEntityManager() {
        this.em = context.getEm();
    }

    private void closingEm(){
        if (em.isOpen() && em != null) {
            em.close();
        }
    }
    private boolean existByName(String langName ) {
        getEntityManager();
        try {
            TypedQuery<Language> query = em.createQuery("SELECT r FROM Language r WHERE r.name = :name", Language.class);
            query.setParameter("name", langName);
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

    private Tag findTagByName(String tagName){
        getEntityManager();
        try {
            TypedQuery<Tag> query = em.createQuery("SELECT r FROM Tag r WHERE r.name = :name", Tag.class);
            query.setParameter("name", tagName);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            closingEm();
        }
    }
}
