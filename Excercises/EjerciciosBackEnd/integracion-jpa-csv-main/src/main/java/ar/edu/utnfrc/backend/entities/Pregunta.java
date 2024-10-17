package ar.edu.utnfrc.backend.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Preguntas")
@NamedQueries({
        @NamedQuery(name = "Pregunta.count", query = "SELECT count(o) FROM Pregunta o"),
        @NamedQuery(name = "Pregunta.findByDescripcion", query = "SELECT o From Pregunta o WHERE o.descripcion = :desc")
})
public class    Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sqlite_sequence", sequenceName = "Preguntas")
    private int id;

    @Column(nullable = false)
    private String descripcion;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "opcion_correcta_id", referencedColumnName = "id")
    private Opcion opcionCorrecta;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "opcion_elegida_id", referencedColumnName = "id")
    private Opcion opcionElegida;

    @OneToMany(mappedBy = "pregunta")
    private List<PreguntaOpcion> preguntasOpciones;

    @OneToMany(mappedBy = "pregunta", cascade = CascadeType.ALL)
    private List<PreguntaExamen> preguntasExamenes;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Opcion getOpcionCorrecta() {
        return opcionCorrecta;
    }

    public void setOpcionCorrecta(Opcion opcionCorrecta) {
        this.opcionCorrecta = opcionCorrecta;
    }

    public Opcion getOpcionElegida() {
        return opcionElegida;
    }

    public void setOpcionElegida(Opcion opcionElegida) {
        this.opcionElegida = opcionElegida;
    }
}
