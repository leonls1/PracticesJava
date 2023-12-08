package edu.ap4t2.jpa.services;

import edu.ap4t2.jpa.daos.ComentarioDAO;
import edu.ap4t2.jpa.daos.PublicacionDAO;
import edu.ap4t2.jpa.entities.Comentario;
import edu.ap4t2.jpa.entities.Publicacion;
import edu.ap4t2.jpa.factories.DAOFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.*;

public class PublicacionRepository {

  private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-example-unit");

  private PublicacionDAO publicacionDAO;

  private ComentarioDAO comentarioDAO;

  public PublicacionRepository() {
    this.publicacionDAO = DAOFactory.gePublicacionDAO();
    this.comentarioDAO = DAOFactory.geComentarioDAO();
  }

  private EntityManager obtenerEntityManagerConfigurado() {
    // obtener el entitymanager
    EntityManager em = emf.createEntityManager();
    // configurar los DAOs con el entitymanager
    publicacionDAO.setEntityManager(em);
    comentarioDAO.setEntityManager(em);
    return em;
  }

  public void add(Publicacion publicacion) throws Exception {
    EntityManager em = obtenerEntityManagerConfigurado();

    // comienza la transaccion
    em.getTransaction().begin();
    // no se está usando cascade, por eso es requerido
    publicacion.getComentarios().stream().forEach(c -> comentarioDAO.create(c));
    publicacionDAO.create(publicacion);
    // finalizar la transaccion
    em.getTransaction().commit();
    em.close();
  }

  public void remove(Publicacion publicacion) throws Exception {
    EntityManager em = obtenerEntityManagerConfigurado();

    // comienza la transaccion
    em.getTransaction().begin();
    // no se está usando cascade, por eso es requerido
    publicacion.getComentarios().stream().forEach(c -> comentarioDAO.delete(c));
    publicacionDAO.delete(publicacion);
    // finalizar la transaccion
    em.getTransaction().commit();
    em.close();
  }

  public Publicacion get(Integer id) throws Exception {
    EntityManager em = obtenerEntityManagerConfigurado();

    // comienza la transaccion
    em.getTransaction().begin();

    // forzar la cargar de los comentarios antes de salir de la capa de servicio
    List<Comentario> comentarios = comentarioDAO.findByPublicacionId(id);
    Publicacion publicacion = publicacionDAO.read(id);
    publicacion.setComentarios(comentarios);

    // finalizar la transaccion
    em.getTransaction().commit();
    em.close();
    return publicacion;
  }

  public void update(Publicacion publicacion) throws Exception {
    EntityManager em = obtenerEntityManagerConfigurado();

    // comienza la transaccion
    em.getTransaction().begin();

    // no se está usando cascade, por eso requerido
    publicacion.getComentarios().stream().forEach(c -> comentarioDAO.update(c));
    publicacionDAO.update(publicacion);
    // finalizar la transaccion
    em.getTransaction().commit();
    em.close();
  }

}
