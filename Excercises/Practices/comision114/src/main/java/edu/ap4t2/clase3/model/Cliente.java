package edu.ap4t2.clase3.model;

import java.time.LocalDate;
import java.time.Period;

public class Cliente {

  private Integer id;
  private String cuit;
  private String nombre;
  private String apellido;
  private LocalDate fechaNac;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCuit() {
    return cuit;
  }

  public void setCuit(String cuit) {
    this.cuit = cuit;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public LocalDate getFechaNac() {
    return fechaNac;
  }

  public void setFechaNac(LocalDate fechaNac) {
    this.fechaNac = fechaNac;
  }

  public int getEdad() {
    return Period.between(fechaNac, LocalDate.now()).getYears();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((cuit == null) ? 0 : cuit.hashCode());
    result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
    result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
    result = prime * result + ((fechaNac == null) ? 0 : fechaNac.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Cliente other = (Cliente) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (cuit == null) {
      if (other.cuit != null)
        return false;
    } else if (!cuit.equals(other.cuit))
      return false;
    if (nombre == null) {
      if (other.nombre != null)
        return false;
    } else if (!nombre.equals(other.nombre))
      return false;
    if (apellido == null) {
      if (other.apellido != null)
        return false;
    } else if (!apellido.equals(other.apellido))
      return false;
    if (fechaNac == null) {
      if (other.fechaNac != null)
        return false;
    } else if (!fechaNac.equals(other.fechaNac))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Cliente [id=" + id + ", cuit=" + cuit + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNac="
        + fechaNac + "]";
  }

}
