package todolist.daos;

import jakarta.persistence.EntityManager;
import todolist.model.entity.Task;

public interface TaskDAO {
    
    //public Task getById(Long id);
    
    //public List<Task> getAll();
    
    public void create(Task task);
    
    //public boolean delete(Long id);
    
    public void update(Task task);

    public Task read(Long id);
    
    public void delete(Task task);
    
    public void setEntityManager(EntityManager em);
    
    //public boolean update(Task task, Long id);
    
    
}
