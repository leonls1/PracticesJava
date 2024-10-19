package pc.leon.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.NaturalId;

import java.util.Set;

@Entity

public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "languages")
    private Set<Repository> repositories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Repository> getRepositories() {
        return repositories;
    }

    public void setRepositories(Set<Repository> repositories) {
        this.repositories = repositories;
    }

    public Language(String name) {
        this.name = name;
    }

    public Language() {
    }
}
