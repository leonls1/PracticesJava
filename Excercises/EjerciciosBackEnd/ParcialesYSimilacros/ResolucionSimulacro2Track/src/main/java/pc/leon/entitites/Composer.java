package pc.leon.entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Table
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Composer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Composer(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composer composer = (Composer) o;
        return Objects.equals(name, composer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Composer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


}