package edu.ap4t2.jpa.factories;

import edu.ap4t2.jpa.daos.ComentarioDAO;
import edu.ap4t2.jpa.daos.ComentarioDAOImpl;
import edu.ap4t2.jpa.daos.PublicacionDAO;
import edu.ap4t2.jpa.daos.PublicacionDAOImpl;

public class DAOFactory {

  public static PublicacionDAO gePublicacionDAO() {
    return new PublicacionDAOImpl();
  }

  public static ComentarioDAO geComentarioDAO() {
    return new ComentarioDAOImpl();
  }

}
