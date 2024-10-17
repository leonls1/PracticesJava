package pc.leon.Ejercicios.aeropuertos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "airport_terminal")
public class AirportTerminal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @OneToMany
    private List<Baggage> conveyorBelt;

    @ManyToOne
    private Airport airport;

    public List<Baggage> analyzeBaggage(String airportCode) {
        //all the baggage that will be moved to deposit
        List<Baggage> baggageForDeposit = new ArrayList<>();

        //for each baggage in the terminal verify if it was analyzed before
        conveyorBelt.forEach(baggage -> {
            if (!baggage.isAnalyzed()) {
                //setting the cost for the baggage
                baggage.analyzeCost();

                //verify if the baggage needs to be sent to another airport, in that case is added
                //to the deposit list
                if (baggage.getDestinyCode().equalsIgnoreCase(airportCode))
                    baggageForDeposit.add(baggage);

                //setting analyzed for don't process twice the same baggage
                baggage.setAnalyzed(true);
            }
        });

        return baggageForDeposit;
    }
}
