package spring_security_JWT.security.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponseDto {

    private String accessToken;
    
    private String tokenType = "Bearer ";
    
    public AuthResponseDto(String accesToken){
        this.accessToken = accesToken;        
    }
}
