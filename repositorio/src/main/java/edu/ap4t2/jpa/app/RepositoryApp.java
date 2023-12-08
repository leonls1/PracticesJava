package edu.ap4t2.jpa.app;

import edu.ap4t2.jpa.entities.Comentario;
import edu.ap4t2.jpa.entities.Publicacion;
import edu.ap4t2.jpa.services.PublicacionRepository;

import java.util.*;

public class RepositoryApp {

  public static final Integer ID_PUBLICACION = Integer.valueOf(12);

  public static void main(String[] args) {
    // Creo la capa de servicio
    PublicacionRepository repo = new PublicacionRepository();
    try {

      // Antes de ejecutar este caso, cambiar en persistence.xml la propiedad
      // <property name="hibernate.hbm2ddl.auto" value="create" />
      casoUno(repo);
      // A partir de aquí. Cambiar la propiedad en persistence.xml
      // <property name="hibernate.hbm2ddl.auto" value="none" />
      // Cambiar constante de clase ID_PUBLICACION con el id de la publicación
      // requerido para todos los casos a continuacion
      // LEER BIEN LA DOC DEL CASO 2 ANTES DE SU EJECUCION (SOBRE EL MÉTODO EN
      // COMENTARIO)
      // casoDos(repo);
      // LEER BIEN LA DOC DEL CASO 3 ANTES DE SU EJECUCION (SOBRE EL MÉTODO EN
      // COMENTARIO)
      // casoTres(repo);
      // LEER BIEN LA DOC DEL CASO 4 ANTES DE SU EJECUCION (SOBRE EL MÉTODO EN
      // COMENTARIO)
      // caso4(repo);
      // LEER BIEN LA DOC DEL CASO 5 ANTES DE SU EJECUCION (SOBRE EL MÉTODO EN
      // COMENTARIO)
      // caso5(repo);
      // LEER BIEN LA DOC DEL CASO 6 ANTES DE SU EJECUCION (SOBRE EL MÉTODO EN
      // COMENTARIO)
      // caso6(repo);

    } catch (Exception e) {
      // em.getTransaction().rollback();
      e.printStackTrace();
    }

  }

  /*
   * Ejecutar cada caso individualmente
   * Primer caso: se crea una publicacion nueva
   */
  private static void casoUno(PublicacionRepository repo) throws Exception {
    // utilizo las capas de servicio de manera transparente
    // Creo una publicacion
    Publicacion p1 = new Publicacion();
    p1.setContenido("Este es el contenido de mi publicacion");
    p1.setTitulo("GRAN PUBLICACION! URGENTE!");

    repo.add(p1);

    System.out.println("Id de la publicacion creada es:" + p1.getId());

  }

  /*
   * Ejecutar cada caso individualmente.
   * Segundo caso: Sobre la publicacion creada en el caso 1, los usuarios realizan
   * sus comentarios.
   * IMPORTANTE!! Completar con el id obtenido en el caso 1 la constante
   * ID_PUBLICACION
   */
  private static void casoDos(PublicacionRepository repo) throws Exception {

    Publicacion p1 = repo.get(ID_PUBLICACION);

    Comentario c1 = new Comentario();
    c1.setContenido("Guauu!! Que buena publicación. Muchas gracias por compartir!");

    Comentario c2 = new Comentario();
    c2.setContenido("No me gusta nada esta publicación!!!");

    Comentario c3 = new Comentario();
    c3.setContenido("Yo tengo un posición neutra frente a todo esto");

    c1.setPublicacion(p1);
    c2.setPublicacion(p1);
    c3.setPublicacion(p1);
    p1.setComentarios(List.of(c1, c2, c3));

    repo.update(p1);

    System.out.println("El id de la publicacion: " + p1.getId());
    System.out.println("El id del comentario1: " + c1.getId());
    System.out.println("El id del comentario2: " + c2.getId());
    System.out.println("El id del comentario2: " + c3.getId());

  }

  /*
   * Ejecutar cada caso individualmente
   * Tercer Caso: Se realiza una modificacion en el titulo de la Publicacion
   * creada en el caso1
   * IMPORTANTE!! Completar con el id obtenido en el caso 1 la constante
   * ID_PUBLICACION
   * 
   */
  private static void casoTres(PublicacionRepository repo) throws Exception {

    Publicacion p1 = repo.get(ID_PUBLICACION);

    p1.setTitulo("ESTA PUBLICACION ES SUPER COOL. NO OLVIDEN COMENTAR");

    repo.update(p1);

  }

  /*
   * Ejecutar cada caso individualmente
   * Cuarto Caso: Se obtienen los comentarios de la publicacion creada en el caso
   * 1 para ser mostrados por pantalla
   * IMPORTANTE!! Completar con el id obtenido en el caso 1 la constante
   * ID_PUBLICACION
   * 
   */
  private static void caso4(PublicacionRepository repo) throws Exception {

    Publicacion p = repo.get(ID_PUBLICACION);

    p.getComentarios().stream().forEach(System.out::println);
  }

  /*
   * Ejecutar cada caso individualmente
   * Quinto Caso: Al usuario que tenía una posición neutra parece que decide
   * modificar su comentario
   * IMPORTANTE!! Completar con el id obtenido en el caso 1 la constante
   * ID_PUBLICACION
   * 
   */
  private static void caso5(PublicacionRepository repo) throws Exception {

    Publicacion p = repo.get(ID_PUBLICACION);

    Optional<Comentario> comentarioAModificar = p.getComentarios().stream()
        .filter(c -> c.getContenido().equals("Yo tengo un posición neutra frente a todo esto"))
        .findFirst();
    if (comentarioAModificar.isPresent()) {
      comentarioAModificar.get().setContenido("Ya no me gusta nada esta publicación");
      repo.update(p);
      System.out
          .println("Verifica en la base de datos la modificación del comentario " + comentarioAModificar.get().getId());
    }

  }

  /*
   * Ejecutar cada caso individualmente
   * Sexto Caso: Al usuario que creó la publicación no le gustan los comentarios
   * obtenidos y decide borrarla.
   * IMPORTANTE!! Completar con el id obtenido en el caso 1 la constante
   * ID_PUBLICACION
   * 
   */
  private static void caso6(PublicacionRepository repo) throws Exception {

    Publicacion p = repo.get(ID_PUBLICACION);

    repo.remove(p);

    System.out.println("Verifica en la base de datos la tabla Comment y la tabla Post");
  }

}
