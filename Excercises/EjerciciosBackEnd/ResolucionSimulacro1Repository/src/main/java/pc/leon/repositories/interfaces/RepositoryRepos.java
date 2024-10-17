package pc.leon.repositories.interfaces;

import pc.leon.entities.Repository;

import java.util.List;

public interface RepositoryRepos {
    void create(Repository repo);
    void update(Repository repo);
    Repository findById(Long id);
    List<Repository> findAll();
    Repository delete(Long id);
    boolean existsById(Long id);
}
