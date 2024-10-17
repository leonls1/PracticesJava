package pc.leon.Ejercicios.Educacional.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Table
@Entity
@NamedQueries({
        @NamedQuery(name = "Test.count",
                query = "select  count(t) From Test t"),
        @NamedQuery(name = "Test.findAll",
                query = "SELECT o FROM Test o"),
        @NamedQuery(name = "Test.findByStudentId",
                query = "select o from Test o where o.student.name = :studentId")
})
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToMany
    @JoinTable(name = "test_x_option",
            joinColumns = @JoinColumn(name = "test_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id"))
    private List<MultipleChoice> questions;
}
//Examen, representa el examen rendido por un alumno, que posee como atributos:
//* Un alumno (instancia de la clase Alumno) y,
//* Una colección con las preguntas que se evalúan.
