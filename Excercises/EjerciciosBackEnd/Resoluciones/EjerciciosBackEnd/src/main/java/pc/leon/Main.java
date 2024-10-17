package pc.leon;

import pc.leon.Ejercicios.perfumeria.Perfumeria;
import pc.leon.Ejercicios.perfumeria.Venta;
import pc.leon.Ejercicios.perfumeria.VentaParcial;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {

//        //---------------------------ejercicio de los transportes
//        Logistica logistica = new Logistica();
//        URL path = Main.class.getResource("/logistica.csv");
//        if (path != null) {
//            logistica.bulkInsert(path.toURI());
//
//        } else {
//            System.out.println("NO se encontro el archivo .csv");
//        }
//
//
//        for (HojaDeRuta hojita : logistica.getHojasDeRuta()) {
//            System.out.println(hojita.toString());
//            System.out.println("precio total de la hojita: " + hojita.totalDeRuta());
//        }
        //------------------------ejercicio perfumeria
        Perfumeria perfumeria = new Perfumeria();
        URL ventasCSV = Main.class.getResource("/ventas.csv");
        if (ventasCSV != null) {
            perfumeria.loadSales(ventasCSV.toURI());

        } else {
            System.out.println("NO se encontro el archivo .csv");
        }

//        //mostrando todos los perfumes cargados
//        System.out.println(perfumeria.toString());
//        System.out.println();

        System.out.println("Ejercicio 2");
        //mostrando ejercicio 2
        System.out.println(
                perfumeria.toString(perfumeria.showSalesUpperXAndDistinctT(1000, 'B'))
        );

        //ejercicio 3
        System.out.println();
        System.out.println("monto acumulado por tipo de perfume");
        System.out.println(
                perfumeria.totalAmountPerPerfumeType((short) 3)
        );

        //ejercicio 4
        System.out.println();
        System.out.println("Ejercicio 4; ");
        List< VentaParcial > list = perfumeria.showPerfumesBetween5And12AndBillTypeDistinctFromC();
        for(Venta venta : list){
            System.out.println(
                    venta.toString()
            );
        }

        //ejercicio 5
        System.out.println();
        System.out.println("Ejercicio 5");
        perfumeria.toString(
                perfumeria.getSalesByBillType('B')
        );

    }
}