package ar.edu.utnfrc.sping_service_web.security.controller;

import ar.edu.utnfrc.sping_service_web.request.LoginRequest;
import ar.edu.utnfrc.sping_service_web.security.jwt.JwtUtils;
import ar.edu.utnfrc.sping_service_web.security.user.service.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authManager;
    private final JwtUtils jwtUtils;
    private final UserDetailService userDetailService;

    @PostMapping("/login")
    public ResponseEntity<?> logIn(LoginRequest loginRequest) {
        try {
            //try to authenticate the user from the login
            Authentication authentication = authManager.authenticate(new
                    UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password()));
            //look for the userDetails with the login info
            UserDetails userDetails =  userDetailService.loadUserByUsername(loginRequest.username());

            //generating the token with the user
            String jwt = jwtUtils.generateJwtForUser(userDetails);

            return ResponseEntity.ok(jwt);
        }catch (Exception ex){
            return new ResponseEntity<>("invalid credentials", HttpStatus.FORBIDDEN);
        }
    }
}
