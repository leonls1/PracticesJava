package spring_security_JWT.security.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_security_JWT.security.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User,Long>{
    
    Optional<User> findByUsername(String username);
    
    boolean existsByUsername(String usename);

}
