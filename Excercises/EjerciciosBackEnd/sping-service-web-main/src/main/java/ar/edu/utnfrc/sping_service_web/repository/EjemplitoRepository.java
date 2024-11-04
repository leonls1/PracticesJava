package ar.edu.utnfrc.sping_service_web.repository;

import ar.edu.utnfrc.sping_service_web.model.entities.Ejemplito;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EjemplitoRepository {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
    EntityManager em = emf.createEntityManager();

    public void createEjemplito(Ejemplito ej){
        em.getTransaction().begin();
        em.persist(ej);
        em.getTransaction().commit();
    }
    public void update(Ejemplito ej){
        em.getTransaction().begin();
        em.persist(ej);
        em.getTransaction().commit();
    }

    public void findByid(Ejemplito ej){
        em.getTransaction().begin();
        em.persist(ej);
        em.getTransaction().commit();
    }

    public void findAll(Ejemplito ej){
        em.getTransaction().begin();
        em.persist(ej);
        em.getTransaction().commit();
    }

    public void delete(Ejemplito ej){
        em.getTransaction().begin();
        em.persist(ej);
        em.getTransaction().commit();
    }
}
