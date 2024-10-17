package pc.leon.Ejercicios.perfumeria;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Perfumeria {
    private List<Venta> ventas = new ArrayList<>();

    // 1- Cargar una colección de objetos del tipo Venta desde el archivo "ventas.csv".
    public void loadSales(URI path) throws IOException, MalformedURLException {
        Files.lines(Paths.get(path))
                .skip(1)//skipping the first line
                .map(Venta::new)
                .forEach(v -> ventas.add(v));
    }


//2- Mostrar todos los datos de las ventas cuyo importe de factura sea mayor a x y el tipo de la factura sea distinto
//de t (x y t son valores que se cargan por teclado). El listado debe salir ordenado el nombre de las personas que
//realizaron la compra.

    public List<Venta> showSalesUpperXAndDistinctT(float x, char t) {
        List<Venta> list = ventas.stream()
                .filter(v -> v.getImporte() > x && v.getTipoFactura() != t)
                .sorted(Comparator.comparing(Venta::getNombreComprador))
                .toList();
        if (list.size() == 0) throw new NoSuchElementException("There isn't sell's with those parameters");
        return list;
    }

    //3- Determinar y mostrar el importe total facturado para uno de los 17 tipos posibles.
    public float totalAmountPerPerfumeType(short type) {
        return (float) ventas.stream()
                .filter(v -> v.getTipoPerfume() == type)
                .mapToDouble(v -> (double) v.getImporte())
                .sum();
    }

    ///4- Mostrar por pantalla el número de factura, el comprador y el importe, de todas las ventas cuyo tipo de perfume
//se encuentre entre 5 y 12 y que no sean con factura de tipo C. Si no existe ninguna venta que cumpla con ese criterio
//disparar NoSuchElementException.
    public List<VentaParcial> showPerfumesBetween5And12AndBillTypeDistinctFromC() {
        List<VentaParcial> sales =
                ventas.stream()
                        .filter(v -> v.getTipoPerfume() > 5 && v.getTipoPerfume() < 12 && v.getTipoFactura() != 'C')
                        .map(v -> new VentaParcial(v.getNroFactura(), v.getNombreComprador(), v.getImporte()))
                        .toList();

        if (sales.size() == 0) throw new NoSuchElementException();

        return sales;
    }

    //5- Obtener una sublista de ventas, para aquellas ventas de un tipo de factura determinada. Si no existen elementos,
//disparar NoSuchElementException
    public List<Venta> getSalesByBillType(char type) {
        List<Venta> sales = ventas.stream()
                .filter(v -> v.getTipoFactura() == type)
                .toList();

        if (sales.isEmpty()) throw new NoSuchElementException();

        return sales;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ventas.forEach(v -> sb.append(v.toString()).append("\n"));
        return sb.toString();
    }

    public String toString(List<Venta>  ven) {
        StringBuilder sb = new StringBuilder();
        ven.forEach(v -> sb.append(v.toString()).append("\n"));
        return sb.toString();
    }


}
