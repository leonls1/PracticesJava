package Task.service;

import Task.model.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class TaskImp implements TaskDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit");
    EntityManager em = emf.createEntityManager();   

/*
    @Override
    public List<Task> getAll() {
        try {
            em.getTransaction().begin();
            
            List<Task> resultList = em.createQuery("SELECT * FROM Task t ORDER BY t.id ", Task.class)
                    .getResultList();
            
            return resultList;
            
        } catch (Exception e) {
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw e;
            
        } finally {
            em.close();
        }
        
    }
*/
    @Override
    public void create(Task task) {
        em.getTransaction().begin();
        em.persist(task);
        em.getTransaction().commit();
    }

    @Override
    public void update(Task task) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Task read(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Task task) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setEntityManager(EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Task> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
