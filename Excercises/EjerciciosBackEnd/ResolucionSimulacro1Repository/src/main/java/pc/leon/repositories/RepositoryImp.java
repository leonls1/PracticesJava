package pc.leon.repositories;

import org.hibernate.HibernateException;
import org.hibernate.NonUniqueResultException;
import pc.leon.entities.Language;
import pc.leon.entities.Repository;
import pc.leon.repositories.context.DBContext;
import pc.leon.repositories.interfaces.LanguageRepository;
import pc.leon.repositories.interfaces.RepositoryRepos;
import pc.leon.repositories.interfaces.TagRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class RepositoryImp implements RepositoryRepos {
    DBContext context = DBContext.getInstance();
    EntityManager em;

    //para todos los repos tengo que definirle un existByName de modo que lo cree si no existe y lo acualize
    //en caso contrario, para este segundo caso otro getByName
    private LanguageRepository langRepo;
    private TagRepository tagRepository;


    @Override
    public void create(Repository repository) {
        getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(repository);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            closingEm();
        }
    }

    @Override
    public void update(Repository repository) {
        getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(repository);
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
    public Repository findById(Long id) {
        getEntityManager();
        Repository repository = em.find(Repository.class, id);
        closingEm();
        return repository;
    }

    @Override
    public List<Repository> findAll() {
        getEntityManager();
        TypedQuery<Repository> query = em.createQuery("select r from Repository r", Repository.class);
        List<Repository> list = query.getResultList();
        closingEm();
        return list;
    }

    @Override
    public Repository delete(Long id) {
        getEntityManager();
        if (existsById(id)) {
            EntityTransaction transaction = em.getTransaction();
            Repository repo = findById(id);
            try {
                transaction.begin();
                em.remove(repo);
                transaction.commit();
            } catch (HibernateException e) {
                transaction.rollback();
                throw new RuntimeException(e);
            } finally {
                closingEm();
            }
            return repo;
        }
        return null;
    }

    @Override
    public boolean existsById(Long id) {
        getEntityManager();
        Repository repo = em.find(Repository.class, id);
        closingEm();
        return (repo != null);
    }

    private void getEntityManager() {
        this.em = context.getEm();
    }

    private void closingEm() {
        if (em.isOpen() && em != null) {
            em.close();
        }
    }

    private boolean existByRepositoryName(String repoName) {
        getEntityManager();
        try {
            TypedQuery<Repository> query = em.createQuery("SELECT r FROM Repository r WHERE r.repositoryName = :name", Repository.class);
            query.setParameter("name", repoName);
            query.getSingleResult();
            return true;
        } catch (NoResultException e) {

            return false;
        } finally {
            closingEm();
        }
    }

    private Repository findRepositoryByName(String repoName){
        getEntityManager();
        try {
            TypedQuery<Repository> query = em.createQuery("SELECT r FROM Repository r WHERE r.repositoryName = :name", Repository.class);
            query.setParameter("name", repoName);
            return query.getSingleResult();
        } catch (NoResultException e) {
           return null;
        } finally {
            closingEm();
        }
    }
}
