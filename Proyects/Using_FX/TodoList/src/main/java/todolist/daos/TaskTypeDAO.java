package todolist.daos;

import jakarta.persistence.EntityManager;
import java.util.List;
import todolist.model.entity.TaskType;

public interface TaskTypeDAO {

    public TaskType getById(Long id);

    public List<TaskType> getAll();

    public void create(TaskType task);

    public boolean delete(Long id);

    public boolean update(TaskType task, Long id);
    
    public void setEntityManager(EntityManager em);
}
