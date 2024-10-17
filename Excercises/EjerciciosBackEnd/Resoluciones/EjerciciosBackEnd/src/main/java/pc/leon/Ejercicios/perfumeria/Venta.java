package pc.leon.Ejercicios.perfumeria;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Venta implements Serializable {
    private String nroFactura;
    private double importe;
    private char tipoFactura;//(A, B, C, E)
    private String nombreComprador;
    private short tipoPerfume;//(1..17)

//factura;importe;tipo;nombre;perfume

    public Venta(String line) {
        String[] elements = line.split(";");
        this.nroFactura = elements[0];
        this.importe = Double.parseDouble(elements[1]);
        this.tipoFactura = elements[2].charAt(0);//get the character at the position 0, the same of the bill code
        this.nombreComprador = elements[3];
        this.tipoPerfume = Short.parseShort(elements[4]);
    }

    public Venta(String numeroFactura, double importe, String nombre) {
        this.nroFactura = numeroFactura;
        this.importe = importe;
        this.nombreComprador = nombre;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "nroFactura=" + nroFactura +
                ", importe=" + importe +
                ", tipoFactura=" + tipoFactura +
                ", nombreComprador='" + nombreComprador + '\'' +
                ", tipoPerfume=" + tipoPerfume +
                '}';
    }


}
