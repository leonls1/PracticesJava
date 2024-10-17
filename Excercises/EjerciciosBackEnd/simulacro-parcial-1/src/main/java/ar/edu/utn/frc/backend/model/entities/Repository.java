package ar.edu.utn.frc.backend.model.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "repositories")
public class Repository {
    @Id
    private Long id;

    @Column(name = "repository_name")
    private String repositoryName;

    private String description;

    private LocalDateTime lastUpdate;

    private Double stars;

    private String url;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "repository_x_tag",
            joinColumns = @JoinColumn(name = "repository_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "repository_x_language",
            joinColumns = @JoinColumn(name = "respoitory_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id"))
    private Set<Language> languages;
// --------------------------------------------getter and setter-------------------------------------
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Double getStars() {
        return stars;
    }

    public void setStars(Double stars) {
        this.stars = stars;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Set<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<Language> languages) {
        this.languages = languages;
    }
//---------------------------------constructor ----------------------------------------
    public Repository(Long id, String repositoryName, String description, LocalDateTime lastUpdate, Double stars, String url, User user, Set<Tag> tags, Set<Language> languages) {
        this.id = id;
        this.repositoryName = repositoryName;
        this.description = description;
        this.lastUpdate = lastUpdate;
        this.stars = stars;
        this.url = url;
        this.user = user;
        this.tags = tags;
        this.languages = languages;
    }

    public Repository(){

    }
//--------------------------------own methods---------------------------------------
    public boolean hasThisTag(Tag tag){
        return tags.contains(tag);
    }

    public boolean hasThisLanguage(Language lang){
        return languages.contains(lang);
    }
//--------------------------------------------------------------------------------------


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repository that = (Repository) o;
        return Objects.equals(id, that.id) && Objects.equals(repositoryName, that.repositoryName) && Objects.equals(description, that.description) && Objects.equals(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, repositoryName, description, lastUpdate);
    }

    @Override
    public String toString() {
        return "Repository{" +
                "id=" + id +
                ", repositoryName='" + repositoryName + '\'' +
                ", description='" + description + '\'' +
                ", lastUpdate=" + lastUpdate +
                ", stars=" + stars +
                ", url='" + url + '\'' +
                ", user=" + user.getName() +
                ", tags=" + tags +
                ", languages=" + languages +
                '}';
    }
}
