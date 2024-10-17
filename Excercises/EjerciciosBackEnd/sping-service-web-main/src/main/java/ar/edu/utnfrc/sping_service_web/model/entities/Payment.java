package ar.edu.utnfrc.sping_service_web.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate paymentDay;

    private double totalPaid;

    @OneToMany(mappedBy = "payment")
    private List<CarRental> rentals;

    public Payment(LocalDate paymentDay, double totalPaid, List<CarRental> rentals) {
        this.paymentDay = paymentDay;
        this.totalPaid = totalPaid;
        this.rentals = rentals;
    }
}
