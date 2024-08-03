package spring_security_JWT.security.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_security_JWT.security.model.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long>{

    Optional<Role> findByDescription(String description);
    
    boolean existsByDescription(String description);
}
