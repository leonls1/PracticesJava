package edu.ap4t2.jpa.daos;

import edu.ap4t2.jpa.entities.Publicacion;
import jakarta.persistence.EntityManager;

public interface PublicacionDAO {

  public void create(Publicacion post);

  public Publicacion read(Integer id);

  public void update(Publicacion post);

  public void delete(Publicacion post);

  public void setEntityManager(EntityManager em);

}
