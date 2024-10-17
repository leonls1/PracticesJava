package pc.leon.Ejercicios.transporte;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Maritimo extends Transporte{
    private short tipoBuque;
    private int totalToneladasTransportadas;

    public Maritimo(String nombre, String matricula, float precioBase,short tipoBuque, int totalToneladasTransportadas) {
        super(nombre, matricula, precioBase);
        this.tipoBuque = tipoBuque;
        this.totalToneladasTransportadas = totalToneladasTransportadas;
    }

    @Override
    public String toString() {
        return  super.toString() + "\n" +
                "Maritimo{" +
                "tipoBuque=" + tipoBuque +
                ", totalToneladasTransportadas=" + totalToneladasTransportadas +
                '}';
    }
}
