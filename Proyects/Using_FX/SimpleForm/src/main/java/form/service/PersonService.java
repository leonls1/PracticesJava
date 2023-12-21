package form.service;

import form.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class PersonService {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit");
    EntityManager em = emf.createEntityManager();
    
    
    public void savePerson(Person per){
    
        em.getTransaction().begin();
        em.persist(per);
        em.getTransaction().commit();
        
    }

    
}