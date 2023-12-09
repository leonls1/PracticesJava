package todolist.daos;

import jakarta.persistence.EntityManager;
import todolist.model.entity.Task;

public class TaskImp implements TaskDAO {

    private EntityManager em;

    @Override
    public void create(Task task) {
        em.persist(task);
    }

    @Override
    public void update(Task task) {
        em.merge(task);
    }

    @Override
    public Task read(Long id) {
        return em.find(Task.class, id);
    }

    @Override
    public void delete(Task task) {
        em.remove(task);
    }

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

}
