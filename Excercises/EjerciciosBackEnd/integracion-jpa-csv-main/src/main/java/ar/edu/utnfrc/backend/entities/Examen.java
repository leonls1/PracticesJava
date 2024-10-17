package ar.edu.utnfrc.backend.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Examenes")
@NamedQueries({
        @NamedQuery(name = "Examen.count", query = "SELECT count(o) FROM Examen o")
})
public class Examen {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sqlite_sequence", sequenceName = "Examenes")
    private int id;

    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alumno_id", referencedColumnName = "id")
    private Alumno alumno;

    @OneToMany(mappedBy = "examen", cascade = CascadeType.ALL)
    private List<PreguntaExamen> preguntasExamenes;


}
