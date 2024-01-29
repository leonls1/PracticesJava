package hibernatepractices1.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class CourseDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit");
    EntityManager em = emf.createEntityManager();
    
    public void create(){
        
    }
    
    public void read(Long id){
        
    }
    public void delete(){
        
    }
    public void update(){
        
    }
    
    public void setEntityManager(EntityManager em){}
    
}
