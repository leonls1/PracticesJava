package ar.edu.utn.bda.JWTDemo.controllers;

import ar.edu.utn.bda.JWTDemo.controllers.response.RandomResponseDTO;
import ar.edu.utn.bda.JWTDemo.domain.ManejadorTokens;
import lombok.extern.slf4j.Slf4j;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@RestController
@RequestMapping("/api/v1/random")
public class RandomController {

    private ManejadorTokens manejadorTokens;

    @Autowired
    public RandomController(ManejadorTokens mt) {
        this.manejadorTokens = mt;
    }

    private Map<String, Object> verificarAutorizacion(Map<String, String> headers) {
        String error = "";
        String headerAutenticacion = headers.getOrDefault("authorization", "");
        String token = headerAutenticacion.replace("Bearer ", "");

        // Debe presentar el header
        if (headerAutenticacion.contains("Bearer ")) {
            try {
                var claims = manejadorTokens.verificarToken(token);
                log.info("Usuario autorizado!");
                return claims;
            } catch (InvalidJwtException ex) {
                log.warn("Token inválido", ex);
                error = ex.getLocalizedMessage();
            }
        } else {
            error = "Header inválido";
        }

        throw new UnauthorizedException(error);
    }

    @GetMapping
    public ResponseEntity<RandomResponseDTO> generarNúmeroAleatorio(@RequestHeader Map<String, String> headers) {
        try {
            // Verificar que el usuario esté autorizado
            var claims = verificarAutorizacion(headers);

            claims.entrySet().forEach(e -> log.info("{}={}", e.getKey(), e.getValue()));

            return ResponseEntity.ok(new RandomResponseDTO(
                    ThreadLocalRandom.current().nextLong(),
                    claims
            ));

        } catch (UnauthorizedException ue) {
            return ResponseEntity
                    .status(401)
                    .header("WWW-Authenticate", "Bearer")
                    .build();
        }
    }
}
