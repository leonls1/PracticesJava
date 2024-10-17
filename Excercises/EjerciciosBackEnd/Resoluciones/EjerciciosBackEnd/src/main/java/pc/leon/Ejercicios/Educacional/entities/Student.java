package pc.leon.Ejercicios.Educacional.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = "Student.count",
                query = "select  count(s) From Student s"),
        @NamedQuery(name = "Student.findAll",
                query = "SELECT s FROM Student s"),
        @NamedQuery(name = "Student.findByEmail",
                query = "select s from Student s where s.email = :email")
})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private int file;

    @Column(name = "document_id", nullable = false, unique = true)
    private Long documentId;

    private String name;

    @OneToOne(mappedBy = "student")
    private Address address;

    @OneToMany(mappedBy = "student")
    private List<Test> tests;

    private String telephone;

    private String email;

}

//Alumno, representa al alumno que rinde el examen. Los atributos que se registran del alumno
//son: legajo (entero), documentoIdentidad, nombre, direccion, telefono, email.
