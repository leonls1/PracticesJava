package pc.leon.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Repository> repositories = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    //La clase User debe mantener un listado de los repositorios que le pertenecen y debe exponer la cantidad total de
    // repositorios y el número de estrellas que ha recibido en todos sus repositorios.

    public int totalRepositories(){
        return repositories.size();
    }

    public long totalStars(){
        //if(!repositories.isEmpty()){
         //   return repositories.stream().mapToInt(Repository::getStars).sum();
        //}
        return 0;
    }
}
