package ar.edu.utnfrc.sping_service_web.controller;

import ar.edu.utnfrc.sping_service_web.model.dtos.UnpaidDetail;
import ar.edu.utnfrc.sping_service_web.model.dtos.PaymentDTO;
import ar.edu.utnfrc.sping_service_web.model.entities.CarRental;
import ar.edu.utnfrc.sping_service_web.model.entities.Payment;
import ar.edu.utnfrc.sping_service_web.service.CarRentalService;
import ar.edu.utnfrc.sping_service_web.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class FinancialController {
    private final PaymentService paymentService;
    private final CarRentalService carRentalService;

    //1. Ingresar un pago, en el body viajan los datos de la fecha de pago, el monto total y el listado de codigos de
    //      alquileres que paga
    @PostMapping("/payment")
    public ResponseEntity<?> createPayment(@RequestBody PaymentDTO paymentDto) {
        List<CarRental> rentals = new ArrayList<>();
        paymentDto.getRentsId().forEach(id -> {
                    CarRental rent = carRentalService.findById(id);
                    rentals.add(rent);
                }
        );
        Payment payment = new Payment(paymentDto.getPaymentDate(), paymentDto.getTotalAmount(), rentals);
        paymentService.create(payment);

        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

}
