package SpringKeyCloak.Spring_keyCloak.model;

import java.util.Set;
import lombok.Builder;

@Builder
public record UserDTO(String username, String email, String firstName, String lastName,
        String password, Set<String> roles)  {    
}
