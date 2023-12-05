package Consoletasklist.model.service;

import Consoletasklist.model.entity.Task;
import java.util.List;

public interface TaskService {
    
    public Task getById(Long id);
    
    public List<Task> getAll();
    
    public void create(Task task);
    
    public boolean delete(Long id);
    
    public boolean update(Task task, Long id);
    
}
