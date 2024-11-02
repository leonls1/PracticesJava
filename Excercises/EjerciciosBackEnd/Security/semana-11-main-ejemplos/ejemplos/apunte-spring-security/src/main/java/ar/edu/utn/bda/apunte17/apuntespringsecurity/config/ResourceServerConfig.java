package ar.edu.utn.bda.apunte17.apuntespringsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class ResourceServerConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                // Esta ruta puede ser accedida por cualquiera, sin autorización
                .requestMatchers("/publico/**")
                .permitAll()

                // Esta ruta puede ser accedida únicamente por usuarios autenticados con el rol de administrador
                .requestMatchers("/protegido-administradores/**")
                .hasRole("ADMIN")

                // esta ruta puede ser accedida únicamente por usuario autenticados
                // con el rol de usuario o administrador
                .requestMatchers("/protegido-usuarios/**")
                .hasAnyRole("USUARIO", "ADMIN")

                // Protegido mixto, GET para "USUARIO" y "ADMIN"
                .requestMatchers(HttpMethod.GET, "/protegido-mixto/**")
                .hasAnyRole("USUARIO", "ADMIN")

                // Protegido mixto, POST para "ADMIN"
                .requestMatchers(HttpMethod.POST, "/protegido-mixto/**")
                .hasRole("ADMIN")

                // Cualquier otra petición...
                .anyRequest()
                .authenticated()

        ).oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));
        return http.build();
    }   

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        var jwtAuthenticationConverter = new JwtAuthenticationConverter();
        var grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();

        // Se especifica el nombre del claim a analizar
        grantedAuthoritiesConverter.setAuthoritiesClaimName("authorities");
        // Se agrega este prefijo en la conversión por una convención de Spring
        grantedAuthoritiesConverter.setAuthorityPrefix("ROLE_");

        // Se asocia el conversor de Authorities al Bean que convierte el token JWT a un objeto Authorization
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(grantedAuthoritiesConverter);
        // También se puede cambiar el claim que corresponde al nombre que luego se utilizará en el objeto
        // Authorization
        // jwtAuthenticationConverter.setPrincipalClaimName("user_name");

        return jwtAuthenticationConverter;
    }

}
