package pc.leon.repositories.interfaces;

import pc.leon.entities.User;

import java.util.List;

public interface UserRepository {
    void create(User user);
    void update(User user);
    User findById(Long id);
    List<User> findAll();
    User delete(Long id);
    boolean existsById(Long id);
}
