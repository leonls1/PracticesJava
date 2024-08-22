package spring_security_JWT.controller;

import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring_security_JWT.security.model.dto.AuthResponseDto;
import spring_security_JWT.security.model.dto.LoginDto;
import spring_security_JWT.security.model.dto.RegisterDto;
import spring_security_JWT.security.model.entity.Role;
import spring_security_JWT.security.model.entity.User;
import spring_security_JWT.security.repository.IRoleRepository;
import spring_security_JWT.security.repository.IUserRepository;
import spring_security_JWT.security.security.jwt.JwtTokenProvider;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth/")
public class authController {

    private final AuthenticationManager authManager;

    private final PasswordEncoder encoder;

    private final IRoleRepository roleRepository;

    private final IUserRepository userRepository;

    private final JwtTokenProvider tokenProvider;

    @PostMapping("register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterDto registerDto) {
        //validar que ese usuario no exista aun
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            return new ResponseEntity<>("ya existe un usuario con ese nombre", HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setPassword(encoder.encode(registerDto.getPassword()));

        //conseguir el rol para "usuario"
        Role roles = roleRepository.findByDescription("USER").get();

        user.setRoles(Collections.singletonList(roles));
        //crendo el usuario
        userRepository.save(user);

        return new ResponseEntity<>("Usuario creado!!", HttpStatus.OK);
    }

    //similar pero para crear a un admin
    @PostMapping("register/admin ")
    public ResponseEntity<String> registerAdmin(@RequestBody RegisterDto registerDto) {
        //validar que ese admin no exista aun
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            return new ResponseEntity<>("ya existe un administrador con ese nombre", HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setPassword(encoder.encode(registerDto.getPassword()));

        //conseguir el rol para "usuario"
        Role roles = roleRepository.findByDescription("ADMIN").get();

        user.setRoles(Collections.singletonList(roles));
        //crendo el usuario
        userRepository.save(user);

        return new ResponseEntity<>("Administrador creado!!", HttpStatus.OK);
    }

    @PostMapping("login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto dto) {
        Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(auth);

        //creando el token si es que el usuario es valido
        String token = tokenProvider.generateToken(auth);
        return new ResponseEntity<>(new AuthResponseDto(token), HttpStatus.OK);
    }

}
