package ar.edu.utnfrc.sping_service_web.exceptionHandling.exceptions;

public class VehicleNotFoundException extends RuntimeException{
    public VehicleNotFoundException(String message){
        super(message);
    }
}
