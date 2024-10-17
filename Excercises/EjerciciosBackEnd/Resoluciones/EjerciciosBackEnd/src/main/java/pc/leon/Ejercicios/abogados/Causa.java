package pc.leon.Ejercicios.abogados;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Causa {
    //Esta **causa** tendrá: un número, el nombre del demandante, estado (1: Abierta - 2: Cerrada), sentencia (1:
    //favorable - 2: no favorable), fuero (1: Civil - 2: Penal) y monto.

    private String numero;
    private String nombreDemandante;
    private int state;
    private int sentencia;
    private int fuero;
    private double amount;

}
