package ar.edu.utnfrc.sping_service_web.controller;

import ar.edu.utnfrc.sping_service_web.model.entities.CarRental;
import ar.edu.utnfrc.sping_service_web.service.CarRentalService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//swagger
@RestController
@RequestMapping("/api/v1/car-rental")
@RequiredArgsConstructor
public class CarRentalController {
    private final CarRentalService service;
    //2. CarRental Controller que tiene los siguientes endpoints que tiene las CRUD operations estandar y:

    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "car rental created")})
    @Operation(summary = "create car rent", tags = "creation", description = "create a car rent, needs a CarRental from the request")
    @PostMapping("/")
    public ResponseEntity<?> createCarRental(
            @Parameter(description = "the rent", required = true) @NonNull @RequestBody CarRental rental) {
        service.create(rental);
        return new ResponseEntity<>("Car Rental successfully created", HttpStatus.CREATED);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "rental obtained"),
            @ApiResponse(responseCode = "400", description = "no rent with the id")
    })
    @GetMapping("/{id}")
    public ResponseEntity<?> getRentalById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    //page version
    @GetMapping("/")
    public ResponseEntity<?> getAllRentals(@RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "10") int size) {
        Page<CarRental> rentalPage = service.findAll(page, size);
        if (!rentalPage.isEmpty()) {
            return new ResponseEntity<>(rentalPage, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No rentals to show", HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/")
    public ResponseEntity<?> updateRental(@RequestBody CarRental carRental) {
        return new ResponseEntity<>(service.update(carRental), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeRental(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>("rental deleted successfully", HttpStatus.OK);
    }
    //   1. Actualizar un alquiler para que se indique pagado, la URI   recibe el id del alquiler.

    @PatchMapping("/{id}")
    public ResponseEntity<?> setRentalToPaid(@PathVariable Long id) {
        service.setRentalToPayed(id);
        return new ResponseEntity<>("rental mark as payed", HttpStatus.OK);
    }

}
