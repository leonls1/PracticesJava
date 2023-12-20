package hibernatepractices1;

import hibernatepractices1.model.entity.Author;
import hibernatepractices1.model.entity.Book;
import hibernatepractices1.service.BookService_jpa;
import hibernatepractices1.service.BookService_spring;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication  
public class HibernatePractices1 {

    public static void main(String[] args) throws Exception {    
        SpringApplication.run(HibernatePractices1.class, args);
        
        BookService_spring serviceSpring  = new  BookService_spring();
        
        BookService_jpa jpaService = new BookService_jpa();
        Book book1 = new Book("librito 1");
        Book book2 = new Book("librito 2");
        Book book3 = new Book("librito 3");
        
        Author auth;
        //auth.setName("auth1");
        /*
        book1.setAuthor(auth);
        book2.setAuthor(auth);
        book3.setAuthor(auth);
        
        auth.setBooks(Arrays.asList(book1, book2, book3));
        */
        //jpaService.saveAuth(auth);     
        
        auth = serviceSpring.getAuthorById(1L);
              
        if (auth != null) {
            System.out.println(auth.getName());
            
        } else {
            System.out.println("No se encontró el autor con el ID proporcionado.");
        }
    }    
        @Bean
    public CommandLineRunner demo(BookService_spring bookService_spring) {
        return args -> {
            /*
            // Guardar un usuario
            Usuario usuario = new Usuario();
            usuario.setNombre("Ejemplo Usuario");
            usuario.setCorreo("usuario@ejemplo.com");
            usuarioService.guardarUsuario(usuario);

            // Obtener todos los usuarios y mostrarlos
            System.out.println("Todos los usuarios:");
            usuarioService.obtenerTodosLosUsuarios().forEach(System.out::println);

            // Obtener un usuario por ID y mostrarlo
            Long idUsuario = 1L;
            Usuario usuarioRecuperado = usuarioService.obtenerUsuarioPorId(idUsuario);
            if (usuarioRecuperado != null) {
                System.out.println("Usuario recuperado por ID: " + usuarioRecuperado);
            } else {
                System.out.println("No se encontró un usuario con ID: " + idUsuario);
            }
        };*/
    }
}
