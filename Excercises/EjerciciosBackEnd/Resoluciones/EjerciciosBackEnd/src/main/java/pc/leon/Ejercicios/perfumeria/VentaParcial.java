package pc.leon.Ejercicios.perfumeria;

public class VentaParcial extends Venta{

    //el número de factura, el comprador y el importe

    public VentaParcial(String numeroFactura, String nombreComprador, double importe) {
        setNroFactura(numeroFactura);
        setNombreComprador(nombreComprador);
        setImporte(importe);
    }

    @Override
    public String toString() {
        return "VentaParcial{" + getNroFactura() + " " + getNombreComprador() + " " + getImporte() +
                "}";
    }
}
