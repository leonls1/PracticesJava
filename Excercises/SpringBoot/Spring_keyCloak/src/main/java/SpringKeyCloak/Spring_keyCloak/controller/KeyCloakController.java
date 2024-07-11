package SpringKeyCloak.Spring_keyCloak.controller;

import SpringKeyCloak.Spring_keyCloak.model.UserDTO;
import SpringKeyCloak.Spring_keyCloak.service.IKeycloakService;
import java.net.URI;
import java.net.URISyntaxException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/keycloak/user")
@PreAuthorize("hasRole('Admin')")
@Slf4j
public class KeyCloakController {

    @Autowired
    private IKeycloakService keycloakServcie;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(keycloakServcie.findAllUser());
    }

    @GetMapping("/search/{username}")
    public ResponseEntity<?> getByUsername(@PathVariable String username) {
        return ResponseEntity.ok(keycloakServcie.findByUsername(username));
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody UserDTO dto) throws URISyntaxException {

        try {
            String response = keycloakServcie.createUser(dto);
            
            if(response.equals("User created successfuly!")){
                return ResponseEntity.created(new URI("/keycloak/user/getAll")).body(response);
            }else{
                return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
            }

            
        } catch (Exception e) {
            log.error("Error creating user", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("internal Server error");
        }
    }

    @PutMapping("/update/{username}")
    public ResponseEntity<?> update(@RequestBody UserDTO dto, @PathVariable String username) {
        keycloakServcie.updateUSer(username, dto);
        return ResponseEntity.ok("User updated successfully");

    }

    @DeleteMapping("/delete/{username}")
    public ResponseEntity<?> delete(@PathVariable String username) {
        keycloakServcie.deleteUser(username);
        return ResponseEntity.noContent().build();
    }

}
