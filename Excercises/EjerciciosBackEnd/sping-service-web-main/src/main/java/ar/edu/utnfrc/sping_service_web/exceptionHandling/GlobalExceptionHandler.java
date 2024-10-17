package ar.edu.utnfrc.sping_service_web.exceptionHandling;

import ar.edu.utnfrc.sping_service_web.exceptionHandling.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<?> handlingClientNotFound(ClientNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ClientCompanyNotFoundException.class)
    public ResponseEntity<?> handlingCompanyNotFound(ClientCompanyNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CarRentalNotFoundException.class)
    public ResponseEntity<?> handlingRentalNotFound(CarRentalNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(VehicleNotFoundException.class)
    public ResponseEntity<?> handlingVehicleNotFound(VehicleNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ClientCompanyHasUnpaidRentException.class)
    public ResponseEntity<?> handlingUnpaidRents(ClientCompanyHasUnpaidRentException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
