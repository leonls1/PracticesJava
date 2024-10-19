package pc.leon.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pc.leon.entities.Repository;

import java.util.List;

public class RepositoryRepository {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("simulacro1");
    EntityManager em = emf.createEntityManager();

    public void saveRepository(Repository repo){
        em.getTransaction().begin();
        em.persist(repo);
        em.getTransaction().commit();
    }

    public void saveAllRepos(List<Repository> repos){
        repos.forEach(this::saveRepository);
    }
}
