package pc.leon.Ejercicios.aeropuertos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MailBag extends Baggage {
    private int packageAmount;
    private MailType contentType;//(1: sobres, 2:enconmiendas)

    public enum MailType {
        NONE,//0
        ENVELOP,//1
        COMMISSION;//2
    }

    @Override
    public void analyzeCost() {
        if (contentType == (MailType.COMMISSION)) {
            setAssociatedCost(getAssociatedCost() * 1.15);
        }
    }
}

