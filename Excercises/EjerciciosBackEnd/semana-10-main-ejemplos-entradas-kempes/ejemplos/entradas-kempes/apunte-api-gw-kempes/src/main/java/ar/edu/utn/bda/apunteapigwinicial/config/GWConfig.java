package ar.edu.utn.bda.apunteapigwinicial.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GWConfig {


    //apunte-api-gw-kempes.url-microservicio-personas=http://localhost:8083
    //apunte-api-gw-kempes.url-microservicio-entradas=http://localhost:8084
    @Bean
    public RouteLocator configurarRutas(RouteLocatorBuilder builder,
                                        @Value("${apunte-api-gw-kempes.url-microservicio-personas}") String uriPersonas,
                                        @Value("${apunte-api-gw-kempes.url-microservicio-entradas}") String uriEntradas) {
        return builder.routes()
                // Ruteo al Microservicio de Personas
                .route(p -> p.path("/api/personas/**").uri(uriPersonas))
                // Ruteo al Microservicio de Entradas
                .route(p -> p.path("/api/entradas/**").uri(uriEntradas))
                .build();

    }

}
