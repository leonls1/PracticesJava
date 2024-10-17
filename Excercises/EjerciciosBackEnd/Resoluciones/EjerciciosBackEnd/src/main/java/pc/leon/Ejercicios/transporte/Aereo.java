package pc.leon.Ejercicios.transporte;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Aereo extends Transporte{
    private int totalBultos;
    private float precioCombustible;

    public Aereo(String matricula, String nombre, float precioBase, int totalBultos, float precioCombustible ) {
        super(nombre, matricula, precioBase);
        this.totalBultos = totalBultos;
        this.precioCombustible = precioCombustible;
    }

    @Override
    public String toString() {
        return super.toString() + "\n"  +
                "Aereo{" +
                "totalBultos=" + totalBultos +
                ", precioCombustible=" + precioCombustible +
                '}';
    }
}
