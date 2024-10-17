package pc.leon.Ejercicios.aeropuertos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Getter
@Setter

@Entity
@Table(name = "airports")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "airport_code")
    private String airportCode;
    @Column(name = "airport_name")
    private String airportName;

    @OneToMany(mappedBy = "airport")
    @JoinColumn(name = "terminal_id")
    private List<AirportTerminal> terminals;

    @OneToOne(mappedBy = "airport")
    private BaggageDeposit baggageDeposit;

    public void addBaggageToDepositForATerminal(long terminalId) {
        if (!terminals.isEmpty()) {
            AirportTerminal terminal = null;
            for (AirportTerminal t : terminals) {
                if (t.getId() == terminalId) {
                    terminal = t;
                    break;
                }
            }
            if (terminal != null) {
                baggageDeposit.getBaggages().addAll(terminal.analyzeBaggage(airportCode));
            } else {
                System.out.println("There isn't a terminal with that id in this airport");
            }
        }
    }

    public void addBaggageToDepositForATerminal(){
        if (!terminals.isEmpty()) {
            terminals.forEach( t ->  baggageDeposit.getBaggages().addAll(t.analyzeBaggage(airportCode)));
        }
    }
}