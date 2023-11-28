package todolist.model.presistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import todolist.model.entity.TaskType;

@Repository
public interface TaskTypeRepository extends JpaRepository<TaskType, Long>{

}
