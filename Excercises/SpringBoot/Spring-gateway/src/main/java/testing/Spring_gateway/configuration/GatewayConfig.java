package testing.Spring_gateway.configuration;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("id_ruta1", r -> r.path("/rutaRecibida1/users/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("https://jsonplaceholder.typicode.com/")
                )
               
                
                .build();
        
        /*return builder.routes()
            .route("user_service", r -> r.path("/api/users/**")
                .filters(f -> f.stripPrefix(2)) // Esto elimina los dos primeros segmentos del path
                .uri("http://localhost:8081"))
            .route("product_service", r -> r.path("/api/products/**")
                .filters(f -> f.stripPrefix(2)) // Esto elimina los dos primeros segmentos del path
                .uri("http://localhost:8082"))
            .build();
*/}
}
