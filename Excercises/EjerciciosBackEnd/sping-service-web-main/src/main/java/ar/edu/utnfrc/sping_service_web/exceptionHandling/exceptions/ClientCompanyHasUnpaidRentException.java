package ar.edu.utnfrc.sping_service_web.exceptionHandling.exceptions;

public class ClientCompanyHasUnpaidRentException extends RuntimeException{
    public ClientCompanyHasUnpaidRentException(String message){
        super(message);
    }
}
