package Leon.ejercicions.SecurityLearn.security;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {
    //secret y elementos basicos para generar el token
    private static final String SECRETO = "clave-secreta";
    private int tokenDuration = 3600000;

    //generar token
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + tokenDuration))
                .signWith(SignatureAlgorithm.HS512, SECRETO.getBytes())
                .compact();
    }

    //obtener usuario de token
    public String extractUsernameFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRETO)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    //validar vencimiento de token
    private boolean validateTokenExpiration(String token){
        return Jwts.parserBuilder()
                .setSigningKey(SECRETO)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration().before(new Date());
    }

    //Validar el token
    public boolean validateToken(String token, String username){
        return (extractUsernameFromToken(token).equals(username) || !validateTokenExpiration(token));
    }
}
