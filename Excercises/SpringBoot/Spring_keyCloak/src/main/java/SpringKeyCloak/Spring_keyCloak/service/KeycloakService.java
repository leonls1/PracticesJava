package SpringKeyCloak.Spring_keyCloak.service;

import SpringKeyCloak.Spring_keyCloak.configuration.KeyCloakProvider;
import SpringKeyCloak.Spring_keyCloak.model.UserDTO;
import jakarta.ws.rs.core.Response;
import java.util.Collections;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KeycloakService implements IKeycloakService {

    @Override
    public List<UserRepresentation> findAllUser() {
        return KeyCloakProvider.getUsersResource().list();
    }

    @Override
    public List<UserRepresentation> findByUsername(String username) {
        return KeyCloakProvider.getUsersResource().search(username);
    }

    @Override
    public String createUser(UserDTO dto) {
        int status = 0;
        UsersResource userResources = KeyCloakProvider.getUsersResource();
        RealmResource realResources = KeyCloakProvider.getRealmResource();

        //this is the way that i need to create the user later
        UserRepresentation userRepresentation = new UserRepresentation();

        //setting the values to my new user
        userRepresentation.setUsername(dto.username());
        userRepresentation.setLastName(dto.lastName());
        userRepresentation.setFirstName(dto.firstName());
        userRepresentation.setEmail(dto.email());
        userRepresentation.setEnabled(true);
        userRepresentation.setEmailVerified(true);

        //getting the response after creating the user
        Response response = userResources.create(userRepresentation);

        status = response.getStatus();

        if (status == 201) {//if the response is 201 so the user was created successfully
            String path = response.getLocation().getPath();

            //getting the user id
            String userId = path.substring(path.lastIndexOf("/" + 1));

            //generating the credeatials to aply at the new user
            CredentialRepresentation credential = new CredentialRepresentation();

            credential.setTemporary(false);
            credential.setType(OAuth2Constants.PASSWORD);
            credential.setValue(dto.password());

            //setting the password
            userResources.get(userId).resetPassword(credential);

            //looking if there's any valid role added for the user 
            List<RoleRepresentation> roles;

            if (dto.roles().isEmpty() || dto.roles() == null) {
                roles = List.of(realResources.roles().get("User").toRepresentation());
            } else {

                //in all the roles passed as parameter i'm going to verify that they are valids
                roles = realResources.roles()
                        .list()
                        .stream()
                        .filter(role -> dto.roles()
                        .stream()
                        .anyMatch(roleName -> roleName.equalsIgnoreCase(role.getName())))
                        .toList();
            }

            userResources.get(userId)
                    .roles()
                    .realmLevel()
                    .add(roles);

            return "User created successfuly!";
        } else if (status == 409) {
            log.error("the user already exists");

            return "user already exists";
        } else {
            log.error("error creating the user");

            return "an error happen";
        }

    }

    @Override
    public void deleteUser(String userID) {
        KeyCloakProvider.getUsersResource()
                .get(userID)
                .remove();
    }

    @Override
    public void updateUSer(String userID, UserDTO dto) {
        CredentialRepresentation cr = new CredentialRepresentation();
        cr.setTemporary(false);
        cr.setType(OAuth2Constants.PASSWORD);
        cr.setValue(dto.password());
        
        UserRepresentation representation = new UserRepresentation();
        representation.setFirstName(dto.firstName());
        representation.setLastName(dto.lastName());
        representation.setEmail(dto.email());
        representation.setUsername(dto.username());
        
        //settinh the password
        representation.setCredentials(Collections.singletonList(cr));
        
        UserResource user = KeyCloakProvider.getUsersResource().get(userID);
        user.update(representation);
        
    }

}
