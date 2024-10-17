package pc.leon.Ejercicios.Educacional.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Table(name = "options")
@Entity
@NamedQueries({
        @NamedQuery(name = "Option.count",
                query = "select  count(o) From Option o"),
        @NamedQuery(name = "Option.findAll",
                query = "SELECT o FROM Option o"),
        @NamedQuery(name = "Option.findByDescription",
                query = "select o from Option o where o.description = :description")
})
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "option_number", nullable = false, unique = true)
    private int optionNumber;

    @Column(nullable = false, unique = true)
    private String description;

}


//Opción, representa una opción de una pregunta multiple choice que posee como atributos:
//número de opción y descripción de la opción.