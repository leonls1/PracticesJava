package SpringKeyCloak.Spring_keyCloak.service;

import SpringKeyCloak.Spring_keyCloak.model.UserDTO;
import java.util.List;
import org.keycloak.representations.idm.UserRepresentation;


public interface IKeycloakService {

    List<UserRepresentation> findAllUser();
    
    List<UserRepresentation> findByUsername(String username);
    
    String createUser(UserDTO dto);
    
    void deleteUser(String userID);
    
    void updateUSer(String userID, UserDTO dto);
            
}
