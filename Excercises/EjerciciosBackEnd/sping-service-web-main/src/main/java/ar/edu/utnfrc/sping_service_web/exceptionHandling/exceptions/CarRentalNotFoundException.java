package ar.edu.utnfrc.sping_service_web.exceptionHandling.exceptions;

public class CarRentalNotFoundException extends RuntimeException{
    public CarRentalNotFoundException(String message){
        super(message);
    }
}
