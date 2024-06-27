package SpringKeyCloak.Spring_keyCloak.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    
    @Autowired 
    private JwtAuthenticationConverter JwtAuthenticationConverter;
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http.csrf(csrf -> csrf.disable()).
                authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated()).
                oauth2ResourceServer(oauth -> {
                    oauth.jwt(jwt -> {
                        jwt.jwtAuthenticationConverter(JwtAuthenticationConverter);
                    });
                }).
                sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }
}
