package spring_security_JWT.security.security.jwt;


public class SecurityConstants {

    //le dejo 5 minutos para que dure el token
    public static final long  JWT_EXPIRATION_TOKEN = 300000;
    
    //firma que se va a encriptar mas tarde 
    public static final String JWT_SIGNATURE = "firma";
}
