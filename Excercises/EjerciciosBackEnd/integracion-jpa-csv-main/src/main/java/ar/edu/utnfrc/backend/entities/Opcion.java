package ar.edu.utnfrc.backend.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Opciones")
@NamedQueries({
        @NamedQuery(name = "Opcion.count", query = "SELECT count(o) FROM Opcion o")
})
public class Opcion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sqlite_sequence", sequenceName = "Opciones")
    private int id;

    @Column(nullable = false)
    private String descripcion;


    @OneToMany(mappedBy = "opcion")
    private List<PreguntaOpcion> preguntaOpciones;

    public Opcion() {
    }

    public Opcion(String descripcion) {
        this.descripcion = descripcion;
    }

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

    public List<PreguntaOpcion> getPreguntaOpciones() {
        return preguntaOpciones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Opcion opcion = (Opcion) o;
        return id == opcion.id && Objects.equals(descripcion, opcion.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion);
    }

    @Override
    public String toString() {
        return "Opcion{" +
                "descripcion='" + descripcion + '\'' +
                ", id=" + id +
                '}';
    }
}
