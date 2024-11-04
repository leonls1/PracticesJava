package ar.edu.utnfrc.sping_service_web.security.user.service;

import ar.edu.utnfrc.sping_service_web.repository.UserRepository;
import ar.edu.utnfrc.sping_service_web.security.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public void createUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        repository.save(user);
    }
}
