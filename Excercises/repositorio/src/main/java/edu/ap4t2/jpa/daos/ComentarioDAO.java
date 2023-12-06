package edu.ap4t2.jpa.daos;

import java.util.*;

import edu.ap4t2.jpa.entities.Comentario;
import jakarta.persistence.EntityManager;

public interface ComentarioDAO {

  public void create(Comentario comentario);

  public Comentario read(Integer id);

  public void update(Comentario comentario);

  public void delete(Comentario comentario);

  public List<Comentario> findByPublicacionId(Integer idPublicacion);

  public void setEntityManager(EntityManager em);
}
