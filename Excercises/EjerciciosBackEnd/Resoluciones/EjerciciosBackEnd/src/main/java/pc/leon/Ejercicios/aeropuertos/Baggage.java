package pc.leon.Ejercicios.aeropuertos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public abstract class Baggage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String baggageCode;
    private String destinyCode;
    private int flightNumber;
    private double associatedCost;
    private boolean isAnalyzed;

    public abstract void analyzeCost();

}
