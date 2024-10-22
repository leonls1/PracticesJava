package pruebas.spring.gatewayTest.configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GatewayConfiguration {

    @Value("${uri-base-service-1}")
    private String baseURL1;

    @Value("${uri-base-service-2}")
    private String baseURL2;

    @Bean
    public RouteLocator configuringRoutes(RouteLocatorBuilder builder) {

        return builder.routes()
                .route("ruta1-service-1", ruta1 -> ruta1.path("/service1/metodo1")
                        .filters(f -> f.setPath("/api/service1/data-from-service-2"))
                        .uri(baseURL1))
                // service 2
                .route("route-service-2", r -> r.path("/redirigir/api/servicio2/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri(baseURL2))
                //external service
                .route("linkedin-profile", external -> external.path("/perfil-linkedin")
                        .filters(f -> f.setPath("/leonlederhos/"))
                        .uri("https://www.linkedin.com/in/"))
                .build();
    }
}
