package Consoletasklist.model.persistence;

import Consoletasklist.model.entity.TaskType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskTypeRepository extends JpaRepository<TaskType,Long>{

}
