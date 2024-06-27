package SpringKeyCloak.Spring_keyCloak.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hello-1")
    @PreAuthorize("hasRole('Admin')")
    public String helloAdmin(){
        return "Hello springBoot using keycloak - Admin";
    }
    
    
    @PreAuthorize("hasRole('Admin') or hasRole('User')" )
    @GetMapping("/hello-2")
    public String helloUser(){  
        return "Hello springBoot using keycloak - User";
    }
}
