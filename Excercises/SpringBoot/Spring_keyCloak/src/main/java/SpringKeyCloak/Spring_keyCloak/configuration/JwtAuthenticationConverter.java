package SpringKeyCloak.Spring_keyCloak.configuration;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimNames;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.stereotype.Component;


@Component
public class JwtAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    private final JwtGrantedAuthoritiesConverter jwtGrantedAuthConverter = new JwtGrantedAuthoritiesConverter();

    @Value("${jwt.auth.converter.principle-attribute}")
    private String principleAtribute;

    @Value("${jwt.auth.converter.resource-id}")
    private String resourceId;

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        //el convertidor para poder tomar el jwt y devolverlo con sus roles respectivos de usuario

        //concateno los streams que me va a dar el jwt junto con todos los roles obtenidos mediante
        //el extractor definido abajo
        Collection<GrantedAuthority> authoritys = Stream.concat(
                jwtGrantedAuthConverter.convert(jwt).stream(),
                 extractResourceRoles(jwt).stream()).
                toList();
        return new JwtAuthenticationToken(jwt, authoritys, getPrincipleAttribute(jwt));
    }

    private Collection<? extends GrantedAuthority> extractResourceRoles(Jwt jwt) {
        //el metodo para obtener los roles o autoridades contenidos dentro del jwt token
        Map<String, Object> resourceAccess;
        Map<String, Object> resource;
        Collection<String> resourceRoles;

        if (jwt.getClaim("resource_access") == null) {
            //si no tengo nada en la claim para resource-acces
            return List.of();
        }
        resourceAccess = jwt.getClaim("resource_access");

        if (resourceAccess.get(resourceId) == null) {
            return List.of();
        }
        resource = (Map<String, Object>) resourceAccess.get(resourceId);

        if (resource.get("roles") == null) {
            return List.of();
        }
        resourceRoles = (Collection<String>) resource.get("roles");

        //recorro todo los los roles y le añado "ROLE_" como prefijo para que no se queje spring
        return resourceRoles.stream().
                map(role -> new SimpleGrantedAuthority("ROLE_".concat(role))).
                toList();

    }
    
    private String getPrincipleAttribute(Jwt jwt){
        
        //por defecto lo que le voy a retornar va a ser lo contenido en el jwt del
        //claim SUB
        String clainName = JwtClaimNames.SUB;
        
        //si el principle attribute que consigo desde application.properties no esta 
        //vacio entonces puedo devolver ese directamente
        if(principleAtribute != null){
            clainName = principleAtribute;
        }
        
        return jwt.getClaim(clainName);        
    }

}
