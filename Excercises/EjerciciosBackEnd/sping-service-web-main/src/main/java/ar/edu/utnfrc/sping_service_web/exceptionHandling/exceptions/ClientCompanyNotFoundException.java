package ar.edu.utnfrc.sping_service_web.exceptionHandling.exceptions;

public class ClientCompanyNotFoundException extends RuntimeException{
    public ClientCompanyNotFoundException(String message){
        super(message);
    }
}
