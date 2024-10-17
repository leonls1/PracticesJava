package ar.edu.utnfrc.sping_service_web.exceptionHandling.exceptions;

public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException(String message){
        super(message);
    }
}
