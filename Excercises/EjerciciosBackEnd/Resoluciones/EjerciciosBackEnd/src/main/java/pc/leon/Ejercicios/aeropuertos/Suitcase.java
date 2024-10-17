package pc.leon.Ejercicios.aeropuertos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Suitcase extends Baggage{
    private int weight;

    @Override
    public void analyzeCost() {
        if(weight > 50){
            setAssociatedCost(
                    getAssociatedCost() * (weight-50)*1.12
            );
        }
    }
}
