package pc.leon.repositories.connection;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DbContext {
    private EntityManager em;
    private static DbContext instance = null;

    private DbContext() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("simulacro2");
        em = emf.createEntityManager();
    }

    public static DbContext getInstance() {
        if (instance == null) {
            instance = new DbContext();
        }
        return instance;
    }
}
