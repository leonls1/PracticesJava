package pc.leon.repositories;

import org.hibernate.HibernateException;
import pc.leon.entities.Language;
import pc.leon.entities.Repository;
import pc.leon.repositories.context.DBContext;
import pc.leon.repositories.interfaces.LanguageRepository;

import javax.persistence.*;
import java.util.List;

public class LanguageImp implements LanguageRepository {

    ////aaaaaaaaaaaaaaaaaaaaa mira vo che, asi solo va a existir un solo emf y em para todos los repos, que piola che
    DBContext context = DBContext.getInstance();
    EntityManager em;

    @Override
    public void create(Language language) {
        getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            if(existByName(language.getName())){
                em.merge(language);
            }else {
                em.persist(language);
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
    public void update(Language language) {
        getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(language);
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
    public Language findById(Long id) {
        getEntityManager();
        Language language = em.find(Language.class, id);
        closingEm();
        return language;
    }

    @Override
    public List<Language> findAll() {
        getEntityManager();
        TypedQuery query = em.createQuery("select l from Language l",Language.class);
        List<Language> list = query.getResultList();
        closingEm();
        return list;
    }

    @Override
    public Language delete(Long id) {
        getEntityManager();
        if (existsById(id)) {
            EntityTransaction transaction = em.getTransaction();
            Language lang = findById(id);
            try {
                transaction.begin();
                em.remove(lang);
                transaction.commit();
            } catch (HibernateException e) {
                transaction.rollback();
                throw new RuntimeException(e);
            } finally {
                closingEm();
            }
            return lang;
        }
        return null;
    }

    @Override
    public boolean existsById(Long id) {
        getEntityManager();
        Language lang = em.find(Language.class, id);
        closingEm();
        return (lang != null);
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

    private Language findLanguageByName(String langName){
        getEntityManager();
        try {
            TypedQuery<Language> query = em.createQuery("SELECT r FROM Language r WHERE r.name = :name", Language.class);
            query.setParameter("name", langName);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            closingEm();
        }
    }
}
