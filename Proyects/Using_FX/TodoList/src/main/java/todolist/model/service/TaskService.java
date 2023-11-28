package todolist.model.service;

import java.util.List;
import todolist.model.entity.Task;

public interface TaskService {
    public Task getById(Long id);
    
    public List<Task> getAll();
    
    public void create(Task task);
    
    public boolean delete(Long id);
    
    public boolean update(Task task, Long id);
    
    
}
