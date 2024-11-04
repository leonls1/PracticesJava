package ar.edu.utnfrc.sping_service_web.security.user.service;


import ar.edu.utnfrc.sping_service_web.exceptionHandling.exceptions.UserNotFoundException;
import ar.edu.utnfrc.sping_service_web.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = repository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("User not found"));
        return user;

    }


}
