package ar.edu.utnfrc.sping_service_web.security.controller;

import ar.edu.utnfrc.sping_service_web.security.user.model.User;

import ar.edu.utnfrc.sping_service_web.security.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping("/")
    public ResponseEntity<?> createUser(@RequestBody  User user){
        service.createUser(user);
        return ResponseEntity.ok("User created successfully");
    }
}
