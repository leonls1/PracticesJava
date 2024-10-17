package pc.leon.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Repositories")
@Getter
@Setter
@NoArgsConstructor
public class Repository {
    @Id
    //@GeneratedValue(strategy = Ge)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_NAME")
    private User user;

    @Column(name = "REPOSITORY_NAME", unique = true)
    private String repositoryName;

    private String description;

    @Column(name = "LAST_UPDATE")
    private LocalDate lastUpdate;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "repository_x_language",
            joinColumns = @JoinColumn(name = "repository_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id"))
    private List<Language> languages;

    private double stars;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "repository_x_tag",
            joinColumns = @JoinColumn(name = "repository_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;

    private String url;

    public Repository(String line) {
        String[] items = line.split("\\|");

        //REPOSITORY_ID|
        Long repoId = Long.valueOf(items[0]);
        //USER_NAME|
        String userName = items[1];
        // REPOSITORY_NAME|
        String repositoryName = items[2];
        // DESCRIPTION|
        String description = items[3];
        // LAST_UPDATE|
        LocalDate lastUpdate = LocalDate.parse(items[4]);
        // LANGUAGE|
        String[] languages = items[5].split(",");
        // STARS
        double stars = Double.valueOf(items[6]);
        //TAGS|
        String[] tags = items[7].split(",");
        // URL
        String repoUrl = items[8];

        //user
        User newUser = new User();
        newUser.setName(userName);

        //languages
        List<Language> langList = new ArrayList<>();
        for (String langName : languages) {
            Language lang = new Language();
            lang.setName(langName);

            langList.add(lang);
        }

        //tags
        List<Tag> tagList = new ArrayList<>();
        for (String tagName : tags) {
            Tag tag = new Tag();
            tag.setName(tagName);

            tagList.add(tag);
        }

        //finalmente el jodido repositorio
        Repository repo = new Repository(repoId, newUser, repositoryName, description, lastUpdate, langList, stars, tagList, repoUrl);
    }

    public Repository(Long id, User user, String repositoryName, String description, LocalDate lastUpdate, List<Language> languages, double stars, List<Tag> tags, String url) {
        this.id = id;
        this.user = user;
        this.repositoryName = repositoryName;
        this.description = description;
        this.lastUpdate = lastUpdate;
        this.languages = languages;
        this.stars = stars;
        this.tags = tags;
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repository that = (Repository) o;
        return Objects.equals(user, that.user) && Objects.equals(repositoryName, that.repositoryName) && Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, repositoryName, url);
    }

    @Override
    public String toString() {
        return "Repository{" +
                "url='" + url + '\'' +
                ", tags=" + tags +
                ", stars=" + stars +
                ", languages=" + languages +
                ", lastUpdate=" + lastUpdate +
                ", description='" + description + '\'' +
                ", repositoryName='" + repositoryName + '\'' +
                ", user=" + user.getName() +
                ", id=" + id +
                '}';
    }

    //La clase Repository debe gestionar y exponer la cantidad de estrellas que tiene el repositorio como un número
    // decimal entre 0 y 5 redondeado a un decimal entendiendo como 5 el máximo número de estrellas existente y
    // manejando el resto de forma proporcional. Y además debe exponer la última actualización como la cantidad de
    // días desde la fecha actual.


    //calcular estrellass
    public double getStars(int maxStars) {
        return Math.round(((double) stars / maxStars) * 5 * 10.0) / 10.0;
    }

    //devolver cuantos dias desde la ultima actualizacion
    public long daysSinceLastUpdate() {
        long days = ChronoUnit.DAYS.between(lastUpdate, LocalDate.now());
        return days;
    }

    //USER_NAME (TEXT): Nombre del usuario propietario del repositorio.
    //REPOSITORY_NAME (TEXT): Nombre del repositorio, es único y debe ser validada su unicidad.
    //DESCRIPTION (TEXT): Descripción del repositorio larga del repositorios y el proyecto.
    //LAST_UPDATE (DATE): Fecha de la última actualización del repositorio.
    //LANGUAGE (TEXT): Lenguajes utilizados en el repositorio, es una lista separada por comas de los lenguajes identificados por nombre.
    //STARS (REAL): Número de estrellas que ha recibido el repositorio.
    //TAGS (TEXT): Etiquetas asociadas al repositorio, es una lista separada por comas de las etiquetas identificadas por nombre.
    //URL (TEXT): URL del repositorio.
}
