package spring_security_JWT.security.security.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import spring_security_JWT.security.security.CustomUserDetailService;


public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private  CustomUserDetailService customUserDetailService;

    @Autowired
    private  JwtTokenProvider jwtTokenProvider;

    private String getTokenFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;

    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //obteniendo el token desde la solicitud
        String token = getTokenFromRequest(request);

        //validando que el token no este vacion y correcto 
        if (StringUtils.hasText(token) && jwtTokenProvider.validateToken(token)) {
            //obtenemos el username que esta asociado al token
            String username = jwtTokenProvider.getUernameFromToken(token);
            
            //cargar el userDetails mediante el username que conseguimos arriba 
            UserDetails userDetails = customUserDetailService.loadUserByUsername(username);
            
            //conseguir todos los roles que ese usuario tiene asociado
            List<String> userRoles = userDetails.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority).toList();
            
            //ver si dentro de todos los roles que tiene el usuario esta USER o ADMIN
            if(userRoles.contains("USER") || userRoles.contains("ADMIN")){
                //creamos el token de authenticacion 
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
                        null, userDetails.getAuthorities());
                
                //al token que creamos recien le agregamos los detalles que se encuentran en la solicitud
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                
                //al contexto le vamos a setear el token de authorizacion
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
            
            filterChain.doFilter(request, response);
        }
    }

}
