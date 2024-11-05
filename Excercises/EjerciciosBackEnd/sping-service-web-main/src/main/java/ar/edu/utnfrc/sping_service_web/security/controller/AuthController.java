package ar.edu.utnfrc.sping_service_web.security.controller;

import ar.edu.utnfrc.sping_service_web.request.LoginRequest;
import ar.edu.utnfrc.sping_service_web.security.jwt.JwtUtils;
import ar.edu.utnfrc.sping_service_web.security.user.service.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authManager;
    private final JwtUtils jwtUtils;
    private final UserDetailService userDetailService;

    @PostMapping("/login")
    public ResponseEntity<?> logIn(@RequestBody LoginRequest loginRequest) {
        System.out.println(loginRequest.password() + " " +  loginRequest.username());
        try {
            //try to authenticate the user from the login
            Authentication authentication = authManager.authenticate(new
                    UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password()));

            //generating the token with the user
            String jwt = jwtUtils.generateJwtForUser((UserDetails) authentication.getPrincipal());

            return ResponseEntity.ok(jwt);
        }catch (BadCredentialsException ex){
            return new ResponseEntity<>("invalid credentials", HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/testing-user")
    public String testing(){
        UserDetails user =userDetailService.loadUserByUsername("usuario1");
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String passwordFromRequest = "1234";
        String storedHashedPassword = "$2a$10$yFEXY44GeZUC1f3.kZngi.Ng4scl1iTItNs6bw8QxUXiRgvELUiom";

        boolean matches = encoder.matches(passwordFromRequest, storedHashedPassword);
        System.out.println("La contraseña coincide: " + matches);
        return user.getPassword() + " " + user.getUsername() + " " + user.getAuthorities();
    }
}
