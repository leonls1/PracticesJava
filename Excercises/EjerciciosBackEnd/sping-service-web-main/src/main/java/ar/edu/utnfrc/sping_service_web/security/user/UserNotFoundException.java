package ar.edu.utnfrc.sping_service_web.security.user;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
