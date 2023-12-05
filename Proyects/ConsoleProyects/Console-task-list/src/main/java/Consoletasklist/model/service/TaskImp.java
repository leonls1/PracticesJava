package Consoletasklist.model.service;

import Consoletasklist.model.entity.Task;
import Consoletasklist.model.persistence.TaskRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TaskImp implements TaskService {
    @Autowired
    private TaskRepository repo;
    
    

    @Override
    public Task getById(Long id) {
        return repo.getReferenceById(id);
    }

    @Override
    public List<Task> getAll() {
        return repo.findAll();

    }

    @Override
    public void create(Task task) {
        repo.save(task);
    }

    @Override
    public boolean delete(Long id) {
        if(repo.existsById(id)){
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Task task, Long id) {
        if(!repo.existsById(id)) return false;
        
        Task oldTask = repo.getReferenceById(id);      
       
        oldTask.setDescription(
            task.getDescription());        
        oldTask.setImportant(
            task.isImportant());
        oldTask.setName(
            task.getName());
        oldTask.setState(
                task.getState());
        oldTask.setType(
                task.getType());
        
        repo.save(oldTask);
        return true;
        
    }
}
