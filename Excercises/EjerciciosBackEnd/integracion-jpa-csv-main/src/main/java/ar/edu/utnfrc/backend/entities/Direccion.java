package ar.edu.utnfrc.backend.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Direcciones")
@NamedQueries({
        @NamedQuery(name = "Direccion.count", query = "SELECT count(o) FROM Direccion o")
})
public class Direccion {
    @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sqlite_sequence", sequenceName = "Direcciones")
    private int id;

    @Column(nullable = false)
    private String calle;

    @Column(name = "codigo_postal")
    private String codigoPostal;

    private String ciudad;

    private String provincia;

    @OneToOne(mappedBy = "direccion", cascade = CascadeType.REFRESH)
    private Alumno alumno;

    public Direccion() {}

    public Direccion(String calle, String codigoPostal, String ciudad, String provincia) {
        this.calle = calle;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.provincia = provincia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direccion direccion = (Direccion) o;
        return id == direccion.id && Objects.equals(calle, direccion.calle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, calle);
    }
}
