package pruebas.spring.gatewayTest.configuration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GatewayConfiguration {

    @Bean
    public RouteLocator configuringRoutes(RouteLocatorBuilder builder) {
        String baseUrlService1 = "http://localhost:8080";

        return builder.routes()
                .route("ruta1-service-1", ruta1 -> ruta1.path("/api/service1/**")
                        .uri(baseUrlService1))
                // service 2
                .route("route-service-2", r -> r.path("/api/servicio2/**")
                        .uri("http://localhost:8081"))
                //external service
                .route("linkedin-profile", external -> external.path("/leonlederhos")
                        .uri("https://www.linkedin.com/in"))
                .build();
    }
}
