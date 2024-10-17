package pc.leon.repositories.context;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBContext {
    /* una forma de aplicar singleton pero no usaria static para traerme el em
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
    EntityManager em;

    public EntityManager getEntityManager(){
        if(em.isOpen() || em == null){
            em = emf.createEntityManager();
        }

        return em;
    }*/

    //otra forma pero esta vez solo creara el emf cuando se lo llame y no antes
    public static DBContext instance;
    public EntityManager  em;

    private DBContext(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("simulacro1");
        em = emf.createEntityManager();
    }

    public static DBContext getInstance(){
        if(instance == null) instance = new DBContext();
        return instance;
    }

    public EntityManager getEm() {
        return em;
    }
}
