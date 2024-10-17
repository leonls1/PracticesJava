package pc.leon.repositories.interfaces;

import pc.leon.entities.Language;

import java.util.List;

public interface LanguageRepository {
    void create(Language language);

    void update(Language language);

    Language findById(Long id);

    List<Language> findAll();

    Language delete(Long id);

    boolean existsById(Long id);
}
