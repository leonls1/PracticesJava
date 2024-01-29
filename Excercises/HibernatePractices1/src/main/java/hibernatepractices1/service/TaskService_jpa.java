package hibernatepractices1.service;

import hibernatepractices1.model.entity.oneToMany.Task;
import hibernatepractices1.model.entity.oneToMany.TaskType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TaskService_jpa {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit");
    EntityManager em = emf.createEntityManager();

    public void createTask(Task task) {
        em.getTransaction().begin();
        em.persist(task);
        em.getTransaction().commit();
    }

    public void createTaskType(TaskType taskType) {
        em.getTransaction().begin();
        em.persist(taskType);
        em.getTransaction().commit();
    }

    public Task getTaskById(Long id) {
        return em.find(Task.class, id);
    }
    
    public TaskType getTaskTypeById(Long id) {
        return em.find(TaskType.class, id);
    }
    
    public void deleteTask(Task task){
        em.getTransaction().begin();
        em.remove(task);
        em.getTransaction().commit();
    }
    
    public void deleteTaskType(TaskType taskType){
        em.getTransaction().begin();
        em.remove(taskType);
        em.getTransaction().commit();
    }
    
    public void updateTask(Task task){
        em.getTransaction().begin();
        em.merge(task);
        em.getTransaction().commit();
    }
    
    public void updateTaskType(TaskType taskType){
        em.getTransaction().begin();
        em.merge(taskType);
        em.getTransaction().commit();
    }
    
    
}
