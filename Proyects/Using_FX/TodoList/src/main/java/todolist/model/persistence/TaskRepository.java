
package todolist.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import todolist.model.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
    
}
