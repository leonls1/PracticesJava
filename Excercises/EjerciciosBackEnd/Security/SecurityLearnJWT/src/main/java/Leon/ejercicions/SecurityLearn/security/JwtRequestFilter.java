package Leon.ejercicions.SecurityLearn.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class JwtRequestFilter extends OncePerRequestFilter {
    private JwtUtils utils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");

        String username = null;
        String jwt = null;

        //si hay un valor para la autorizacion y esta misma empieza con bearer entonces tiene un token
        if (authorizationHeader != null &&  authorizationHeader.startsWith("Bearer")) {
            //aca cargo por una parte el token y por otra parte consigo entonces el usuario
            jwt = authorizationHeader.substring(7); //because the 7 before characters are "Bearer "
            username = utils.extractUsernameFromToken(jwt);
        }

        //si hay un usuario para este token y no tenes ningun contexto de autenticacion
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            //valido el token que me llego
            if (utils.validateToken(jwt, username)) {
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request,response);
    }
}
