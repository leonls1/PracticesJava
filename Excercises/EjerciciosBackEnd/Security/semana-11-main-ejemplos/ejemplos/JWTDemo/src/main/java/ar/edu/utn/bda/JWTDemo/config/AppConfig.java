package ar.edu.utn.bda.JWTDemo.config;

import ar.edu.utn.bda.JWTDemo.domain.ManejadorTokens;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ManejadorTokens crearManejadorTokens(
            @Value("${tokens.nombre_llave}") String nombreLlave,
            @Value("${tokens.algoritmo}") String algoritmo,
            @Value("${tokens.secreto}") String secreto,
            @Value("${tokens.validez_segundos}") long duracionSegundos) {

        return new ManejadorTokens(nombreLlave, algoritmo, secreto, duracionSegundos);
    }

}
