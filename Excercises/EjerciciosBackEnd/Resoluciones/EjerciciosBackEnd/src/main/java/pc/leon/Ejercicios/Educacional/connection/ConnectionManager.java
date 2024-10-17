package pc.leon.Ejercicios.Educacional.connection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectionManager {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("educational");
    private static EntityManager em;

    public static EntityManager getEntityManager(){
        if(em!= null){
            em = emf.createEntityManager();
        }
        return em;
    }
    public static void setEntityManager(EntityManager entityManager){
        em = entityManager;
    }


}
