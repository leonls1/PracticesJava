package com.api.rest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecuriyConfiguration {

    @Bean
    public SecurityFilterChain getFilterChain(HttpSecurity http) throws Exception {

        return http.
                authorizeHttpRequests(request -> request.anyRequest().authenticated()).
                csrf(csrf -> csrf.disable()).
                oauth2ResourceServer(oauth -> {
                    oauth.jwt(jwt -> {
                    });
                })
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }
}
