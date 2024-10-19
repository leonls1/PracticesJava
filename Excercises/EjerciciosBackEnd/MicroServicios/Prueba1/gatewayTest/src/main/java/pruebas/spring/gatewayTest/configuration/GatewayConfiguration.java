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
                .route("ruta1-service-1", ruta1 -> ruta1.path("/service1/method-mono")
                        .uri(baseUrlService1 + "/data-from-service-2"))
                .route("ruta2-service-1", ruta2 -> ruta2.path("/service1/method-flux")
                        .uri(baseUrlService1 + "/getting-a-list"))
                // service 2
                .route("route-service-2", r -> r.path("/service2")
                        .uri("http://localhost:8081/endpoint-with-list"))
                //external service
                .route("linkedin-profile", external -> external.path("/linkedin-profile")
                        .uri("https://www.linkedin.com/in/leonlederhos/"))
                .build();
    }
}
