package ar.edu.utnfrc.sping_service_web.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int yearModel;

    private String brandName;

    private boolean compact;

    private String driverName;

    private int costHour;

    private int totalMiles;

    @OneToMany(mappedBy = "vehicle")
    private List<CarRentalDetail> details;
}
