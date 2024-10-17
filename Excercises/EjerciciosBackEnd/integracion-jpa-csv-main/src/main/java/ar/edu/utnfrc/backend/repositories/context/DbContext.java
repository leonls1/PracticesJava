package ar.edu.utnfrc.backend.repositories.context;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DbContext {

    public static DbContext instance = null;
    private EntityManager manager;

    private DbContext() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("academico");
        this.manager = emf.createEntityManager();
    }

    public static DbContext getInstance() {
        if (instance == null) {
            instance = new DbContext();
        }
        return instance;
    }

    public EntityManager getManager() {return this.manager;}
}
