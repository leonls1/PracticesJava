package spring_security_JWT.security.model.dto;

import lombok.Data;

@Data
public class LoginDto {

    private String username;
    
    private String password;
}
