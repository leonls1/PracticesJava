package ar.edu.utnfrc.backend.entities;

import jakarta.persistence.*;

import java.security.DigestException;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Alumnos")
@NamedQueries({
        @NamedQuery(name = "Alumno.findByDocumentoIdentidad",
                query = "SELECT a FROM Alumno a Where a.documentoIdentidad = :dni"),
        @NamedQuery(name = "Alumno.findByEmail", query = "SELECT a FROM Alumno a WHERE a.email = :email"),
        @NamedQuery(name = "Alumno.count", query = "SELECT count(o) FROM Alumno o")
})
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sqlite_sequence", sequenceName = "Alumnos")
    private int id;

    @Column(unique = true, nullable = false)
    private int legajo;

    @Column(name = "documento_identidad", nullable = false)
    private String documentoIdentidad;

    @Column(nullable = false)
    private String nombre;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direccion", referencedColumnName = "id")
    private Direccion direccion;

    @Basic
    private String telefono;

    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany(mappedBy = "alumno")
    private List<Examen> examenes;

    public Alumno() {
    }

    public Alumno(int legajo, String documentoIdentidad, String nombre, Direccion direccion, String telefono,
                  String email) {
        this.legajo = legajo;
        this.documentoIdentidad = documentoIdentidad;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public Alumno(String line) {

        String[] valores = line.split(";");
        String calle, codigo_postal, ciudad, provincia;

        this.legajo = Integer.parseInt(valores[0]);
        this.documentoIdentidad = valores[1];
        this.nombre = valores[2];
        this.telefono = valores[3];
        this.email = valores[4];

        calle = valores[5];
        codigo_postal = valores[6];
        ciudad = valores[7];
        provincia = valores[8];

        this.direccion = new Direccion(calle, codigo_postal, ciudad, provincia);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Examen> getExamenes() {
        return examenes;
    }

    public void setExamenes(List<Examen> examenes) {
        this.examenes = examenes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return id == alumno.id && legajo == alumno.legajo &&
                Objects.equals(documentoIdentidad, alumno.documentoIdentidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, legajo, documentoIdentidad);
    }
}
