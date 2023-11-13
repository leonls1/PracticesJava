package edu.ap4t2.model;

import java.util.ArrayList;
import java.util.List;

public class Materia {

  private static Long idGlobal = 0L;

  private Long id;

  private String nombre;

  private List<Materia> correlativas;

  public Materia() {
  }

  public Materia(String nombre) {
    this.nombre = nombre;
  }

  public static Long getIdGlobal() {
    return idGlobal;
  }

  public static void setIdGlobal(Long idGlobal) {
    Materia.idGlobal = idGlobal;
  }

  public void incrementIdGlobal() {
    Materia.idGlobal++;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void addMateriaCorrelativa(Materia m) {
    if (correlativas == null) {
      correlativas = new ArrayList<>();
    }
    correlativas.add(m);
  }

  @Override
  public String toString() {
    return "Materia [id=" + id + ", nombre=" + nombre + ", correlativas=" + correlativas + "]";
  }

}
