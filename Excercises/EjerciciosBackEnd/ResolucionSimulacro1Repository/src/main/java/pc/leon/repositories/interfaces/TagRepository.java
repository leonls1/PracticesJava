package pc.leon.repositories.interfaces;

import pc.leon.entities.Tag;

import java.util.List;

public interface TagRepository {
    void create(Tag tag);

    void update(Tag tag);

    Tag findById(Long id);

    List<Tag> findAll();

    Tag delete(Long id);

    boolean existsById(Long id);
}
