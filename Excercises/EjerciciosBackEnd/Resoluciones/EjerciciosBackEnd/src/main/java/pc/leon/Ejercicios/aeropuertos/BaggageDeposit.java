package pc.leon.Ejercicios.aeropuertos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Table
@Entity
public class BaggageDeposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "deposit")
    private List<Baggage> baggages;
}
