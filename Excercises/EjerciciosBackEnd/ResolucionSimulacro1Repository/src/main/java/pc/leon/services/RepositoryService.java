package pc.leon.services;

import org.hibernate.HibernateException;
import pc.leon.entities.Language;
import pc.leon.entities.Repository;
import pc.leon.entities.Tag;
import pc.leon.repositories.LanguageImp;
import pc.leon.repositories.RepositoryImp;
import pc.leon.repositories.TagImp;
import pc.leon.repositories.interfaces.LanguageRepository;
import pc.leon.repositories.interfaces.RepositoryRepos;
import pc.leon.repositories.interfaces.TagRepository;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepositoryService {
    private RepositoryRepos repository;
    private LanguageRepository languageRepository;
    private TagRepository tagRepository;

    public RepositoryService() {
        this.repository = new RepositoryImp();
        this.languageRepository = new LanguageImp();
        this.tagRepository = new TagImp();
    }

    public RepositoryService(RepositoryRepos repository) {
        this.repository = new RepositoryImp();
    }

    //---------------------------------------operaciones crud
    public Repository findById(Long id) {
        return repository.findById(id);
    }

    public List<Repository> findAll() {
        return repository.findAll();
    }


    public Repository delete(Long id) {
        return repository.delete(id);
    }

    public void create(Repository repo){
        repository.create(repo);
    }

    public void update(Repository repo){
        repository.update(repo);
    }



    //Repositorios por usuario.
    public List<Repository> getReposByUser(String userName) {
        return repository.findAll().stream()
                .filter(r -> r.getUser().getName() == userName)
                .toList();
    }

    //Repositorios por lenguaje.
    public List<Repository> getReposByLanguage(Language lang) {
        return repository.findAll().stream()
                .filter(r -> r.getLanguages().contains(lang))
                .toList();
    }

    //Repositorios por etiqueta.
    public List<Repository> getReposByTag(Tag tag) {
        return repository.findAll().stream()
                .filter(r -> r.getTags().contains(tag))
                .toList();
    }

    //Consultar la lista de repositorios de un usuario específico
    // y la lista de lenguajes que utiliza en todos sus repositorios.

    public Set<Language> languagesPerUser(String userName){
        List<Repository> reposPerUser = getReposByUser(userName);
        Set<Language> languages= new HashSet<>();
        reposPerUser.stream()
                .forEach(repo -> languages.addAll(repo.getLanguages()));
        return languages;
    }
}
