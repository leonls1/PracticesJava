package ar.edu.utnfrc.sping_service_web.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class CarRentalDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pickedUpPlace;

    private String destination;

    @Column
    private int hoursTraveled;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "vehicule_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "car_rental_id")
    private CarRental carRental;

}
