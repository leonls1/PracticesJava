package edu.ap4t2.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Comment")
public class Comentario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "content")
  private String contenido;

  @ManyToOne
  @JoinColumn(name = "fk_post_id")
  private Publicacion publicacion;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getContenido() {
    return contenido;
  }

  public void setContenido(String contenido) {
    this.contenido = contenido;
  }

  public Publicacion getPublicacion() {
    return publicacion;
  }

  public void setPublicacion(Publicacion publicacion) {
    this.publicacion = publicacion;
  }

  @Override
  public String toString() {
    return "Comentario [id=" + id + ", contenido=" + contenido + "]";
  }

}
