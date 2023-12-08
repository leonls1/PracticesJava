package edu.ap4t2.jpa.daos;

import edu.ap4t2.jpa.entities.Publicacion;
import jakarta.persistence.EntityManager;

public class PublicacionDAOImpl implements PublicacionDAO {

  private EntityManager em;

  public void create(Publicacion publicacion) {
    em.persist(publicacion);
  }

  public Publicacion read(Integer id) {
    return em.find(Publicacion.class, id);
  }

  public void update(Publicacion publicacion) {
    em.merge(publicacion);
  }

  public void delete(Publicacion publicacion) {
    Publicacion p = em.merge(publicacion);
    em.remove(p);
  }

  public void setEntityManager(EntityManager em) {
    this.em = em;
  }

}
