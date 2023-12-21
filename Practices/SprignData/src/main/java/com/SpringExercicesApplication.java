package com;


import com.model.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.service.UserImp;

@SpringBootApplication
public class SpringExercicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringExercicesApplication.class, args);
    }
    
     @Bean
    public CommandLineRunner demo(UserImp usuarioService) {
        return args -> {
            // Guardar un usuario
            Person usuario = new Person();
            usuario.setName("Ejemplo Usuario");
            usuario.setEmail("usuario@ejemplo.com");
            usuarioService.create(usuario);

            // Obtener todos los usuarios y mostrarlos
            System.out.println("Todos los usuarios:");
            usuarioService.getAll().forEach(System.out::println);

            // Obtener un usuario por ID y mostrarlo
            Long idUsuario = 1L;
            Person usuarioRecuperado = usuarioService.getByID(idUsuario);
            if (usuarioRecuperado != null) {
                System.out.println("Usuario recuperado por ID: " + usuarioRecuperado);
            } else {
                System.out.println("No se encontró un usuario con ID: " + idUsuario);
            }
        };
    }

}
