package edu.ap4t2.jpa.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.*;

import edu.ap4t2.jpa.entities.Comentario;

public class ComentarioDAOImpl implements ComentarioDAO {

  private EntityManager em;

  public void create(Comentario comentario) {
    em.persist(comentario);
  }

  public Comentario read(Integer id) {
    return em.find(Comentario.class, id);
  }

  public void update(Comentario comentario) {
    em.merge(comentario);
  }

  public void delete(Comentario comentario) {
    Comentario c = em.merge(comentario);
    em.remove(c);
  }

  public List<Comentario> findByPublicacionId(Integer idPublicacion) {
    TypedQuery<Comentario> q = em.createQuery("select c from Comentario c where c.publicacion.id = :publicacionId",
        Comentario.class);
    q.setParameter("publicacionId", idPublicacion);
    return q.getResultList();
  }

  public void setEntityManager(EntityManager em) {
    this.em = em;
  }

}
