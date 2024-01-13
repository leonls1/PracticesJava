package Task.service;

import Task.model.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class TaskImp implements TaskDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit");
    EntityManager em = emf.createEntityManager();

  
    @Override
    public void create(Task task) {
        em.getTransaction().begin();
        em.persist(task);
        em.getTransaction().commit();
    }

    @Override
    public void update(Task task) {
        em.getTransaction().begin();
        em.merge(task);
        em.getTransaction().commit();
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
        try {
            // Comienza la transacción (si estás utilizando transacciones manuales)
            em.getTransaction().begin();

            // Utiliza JPQL (Java Persistence Query Language) para obtener todos los objetos de la entidad
            String jpql = "SELECT e FROM Task e";
            Query query = em.createQuery(jpql, Task.class);
            List<Task> listaDeEntidades = query.getResultList();

            // Termina la transacción (si estás utilizando transacciones manuales)
            em.getTransaction().commit();

            return listaDeEntidades;
        } catch (Exception e) {
            e.printStackTrace();
            // Maneja las excepciones de manera apropiada según tus necesidades
        }
        return null;
    }
}

