package Testing_DB.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repositorio extends JpaRepository<Entidad, Long>{

}
