package ar.edu.utn.frc.backend.model.repository;

import ar.edu.utn.frc.backend.model.entities.Language;
import ar.edu.utn.frc.backend.model.entities.Repository;
import ar.edu.utn.frc.backend.model.entities.Tag;
import ar.edu.utn.frc.backend.model.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class RepositoryRepository {
    private EntityManagerFactory emf;
    private EntityManager em;

    public RepositoryRepository(){
        this.emf = Persistence.createEntityManagerFactory("repository-db");
        this.em = emf.createEntityManager();
    }

    public void saveRepository(Repository repo) {
        begin();
        em.persist(repo);
        commit();
    }

    public void saveAllRepositories(List<Repository> repositories) {
        repositories.forEach(
                this::saveRepository
        );
    }

    //Repositorios por usuario.
    public List<Repository> getRepositoriesByUser(User user) {
        return null;
    }

    //Repositorios por lenguaje.
    public List<Repository> getRepositoriesByLanguage(Language lang) {
        return null;
    }

    //Repositorios por etiqueta.
    public List<Repository> getRepositoriesByTag(Tag tag) {
        return null;
    }

    //Consultar la lista de repositorios de un usuario específico y la lista de lenguajes que utiliza en todos sus repositorios.
    public String getTepositoriesAndLanguagesUsedByUser(User user){
        return null;
    }
    private void begin() {
        em.getTransaction().begin();
    }

    private void commit() {
        em.getTransaction().commit();
    }


}
