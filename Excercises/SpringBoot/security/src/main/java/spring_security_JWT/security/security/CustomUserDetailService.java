package spring_security_JWT.security.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import spring_security_JWT.security.model.entity.Role;
import spring_security_JWT.security.model.entity.User;
import spring_security_JWT.security.repository.IUserRepository;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService{

    private final IUserRepository userRepository;
    
    //obtener mediante una lista de roles(como la que tienen los usuarios) una lista de autoridades para ella
    private Collection<GrantedAuthority> mapToAuthorities(List<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getDescription()))
                .collect(Collectors.toList());
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));
        return new org.springframework.security.core.userdetails.User(
           user.getUsername(), user.getPassword(), mapToAuthorities(user.getRoles()));
    }

    
}
