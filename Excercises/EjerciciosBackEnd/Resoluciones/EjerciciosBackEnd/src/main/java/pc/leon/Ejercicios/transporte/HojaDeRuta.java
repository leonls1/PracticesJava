package pc.leon.Ejercicios.transporte;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HojaDeRuta {
    private String codigo;
    private String origen;
    private String destino;
    private String nombreCliente;
    private Transporte transporteUtilizado;


    /*
    1. Transporte Aereo: Al precio base del transporte se le suma el precio del combustible y se le suman 250 dolares
     por cada bulto que se transporta
    2. Transporte Maritimo: Al precio base del tranporte se le suma 450 dolares por tonelada transportada y
    adicionalmente se le cobra un seguro por tipo de barco de una suma igaul a el 40 % del precio base
     */

    public float totalDeRuta(){
        if(transporteUtilizado instanceof  Aereo){
            Aereo t = (Aereo) transporteUtilizado;
            return t.getTotalBultos()*250 + t.getPrecioBase() + t.getPrecioCombustible();
        }else {
            Maritimo m = (Maritimo) transporteUtilizado;
            return  m.getPrecioBase() + m.getTotalToneladasTransportadas()*450 + m.getTipoBuque()*m.getPrecioBase();
        }
    }

    @Override
    public String toString() {
        return "HojaDeRuta{" +
                "codigo='" + codigo + '\'' +
                ", origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", transporteUtilizado=" + transporteUtilizado.toString() +
                '}';
    }
}
