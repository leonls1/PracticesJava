package spring_security_JWT.security.security.jwt;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtTokenProvider {


    private String JwtSecret = SecurityConstants.JWT_SIGNATURE;

    @Value("${}")
    private int jwtExpiration;

    //metodo para generar el token
    public String generateToken(Authentication auth) {
        UserDetails userPrincipal = (UserDetails) auth.getPrincipal();
        String role = userPrincipal.getAuthorities().toString();

        return Jwts.builder()
                .subject(userPrincipal.getUsername())
                .issuedAt(new Date())
                .expiration(new Date(new Date().getTime() + jwtExpiration))
                .claim("role", role)
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.JWT_SIGNATURE)
                .compact();
    }

    //metodo para desencriptar el secret de jwt que tengo en el properties
    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(JwtSecret));
    }

    //metodo para obtener el username desde el token
    public String getUernameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(SecurityConstants.JWT_SIGNATURE)
                .build()
                .parseClaimsJws(token).getBody().getSubject();

    }
//validar el token y capturar las diferentes excepciones si no es valido

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SecurityConstants.JWT_SIGNATURE).build().parse(token);
            return true;
        } catch (MalformedJwtException e) {
            log.error("El token esta mal formado: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("El token ya expiro: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("El token no se soporta: {} ", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("Argumento no encontrado: {}", e.getMessage());
        }
        return false;

    }
}
