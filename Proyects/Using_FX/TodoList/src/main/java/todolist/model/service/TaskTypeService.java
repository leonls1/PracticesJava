package todolist.model.service;

import java.util.List;
import todolist.model.entity.TaskType;

public interface TaskTypeService {

    public TaskType getById(Long id);

    public List<TaskType> getAll();

    public void create(TaskType task);

    public boolean delete(Long id);

    public boolean update(TaskType task, Long id);
}
