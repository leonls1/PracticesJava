package todolist.model.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import todolist.daos.TaskDAO;
import todolist.daos.TaskTypeDAO;
import todolist.model.entity.Task;
import todolist.model.factories.DAOFactory;

public class TaskRepository {

    private TaskDAO taskService;
    private TaskTypeDAO taskTypeService;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit");

    public TaskRepository() {
        taskService = DAOFactory.getTaskDao();
        taskTypeService = DAOFactory.getTastTypeDao();
    }

    private EntityManager getEntityManager() {
        EntityManager em = emf.createEntityManager();
        taskService.setEntityManager(em);
        taskTypeService.setEntityManager(em);

        return em;
    }

    public void create(Task task) throws Exception {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            taskService.create(task);
            em.getTransaction().commit();  // Commit si todo está bien
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;  // Volver a lanzar la excepción después de hacer rollback
        } finally {
            em.close();
        }
    }

    public void update(Task task) {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            taskService.update(task);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public void delete(Task task) {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            taskService.delete(task);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public Task read(Long id) throws Exception {
        EntityManager em = getEntityManager();
        Task task = new Task();
        try {
            em.getTransaction().begin();
            task = taskService.read(id);

        } catch (Exception e) {
            throw e;
        } finally {
            em.close();
            if (task != null) {
                return task;
            } else {
                throw new Exception();
            }
        }

    }

}
