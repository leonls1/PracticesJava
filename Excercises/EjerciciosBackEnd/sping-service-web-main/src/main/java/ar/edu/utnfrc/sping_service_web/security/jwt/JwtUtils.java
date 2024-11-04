package ar.edu.utnfrc.sping_service_web.security.jwt;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int jwtExpiration;

    //generating here the token for the user loaded
    public String generateJwtForUser(UserDetails userDetails) {
        //here i'm getting the user from the current authentication and its roles

        String rol = userDetails.getAuthorities().toString();

        return Jwts.builder()
                //adding the username to the jwt
                .setSubject(userDetails.getUsername())
                //adding the role got
                .claim("role", rol)
                //date generated at
                .setIssuedAt(new Date())
                //expires at
                .setExpiration(new Date((new Date()).getTime() + jwtExpiration))
                //signed with
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();
    }

    //generate a key
    private Key key() {
        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    //gets the username from the token
    public String extractUsername(String token) {
        //first part
        return Jwts.parserBuilder()
                .setSigningKey(key())
                .build()
                //getting the subject from the token
                .parseClaimsJws(token).getBody().getSubject();
    }

    //validate the token received
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key())
                    .build()
                    .parse(token);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
