package pc.leon.Ejercicios.transporte;

import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
public class Logistica {
    private List<HojaDeRuta> hojasDeRuta = new ArrayList<>();
    private int mesEnvio;
    private int anioEnvio;

    public void bulkInsert(URI path) throws FileNotFoundException {
        File file = new File(path);
        Scanner sc = new Scanner(file);
        //skipping the first line
        boolean firstLine = true;
        while(sc.hasNextLine()){
            if(firstLine){
                firstLine = false;
                continue; //skip the first iteration
            }
            try {
                String line = sc.nextLine();
                HojaDeRuta hojita = cargarHojita(line);
                addHojaDeRuta(hojita);
            } catch (NumberFormatException e) {
                System.out.println("error tratando de parsear el numero, se cargo mal en el archivo");;
                continue;
            }
        }
    }

    private void addHojaDeRuta(HojaDeRuta hojita){
        if(hojita != null){
            hojasDeRuta.add(hojita);
        }

    }

    private HojaDeRuta cargarHojita(String line){
        HojaDeRuta hojita = new HojaDeRuta();
        //Decompose the line into an array of strings
        String[] elements = line.split(";");
        //codigo[0] origen[1]   destino[2]  cliente[3]  matricula[4]    precio_base[5]  nombre[6];
        //bultos[7] precio_combustible[8]   tipo_buque[9]               toneladas[10]
        Transporte t;

        String codigo = (elements[0]);
        String origen  = (elements[1]);
        String destino = (elements[2]);
        String cliente = (elements[3]);

        String matricula = (elements[4]);
        float precioBase = Float.parseFloat(elements[5]);
        String nombreTransporte = elements[6];
        int bultos = Integer.parseInt(elements[7]);
        float precioCombustible = Float.parseFloat(elements[8]);
        int tipoBuque = Integer.parseInt(elements[9]);
        int toneladas = Integer.parseInt(elements[10]);

        hojita.setCodigo(codigo);
        hojita.setOrigen(origen);
        hojita.setDestino(destino);
        hojita.setNombreCliente(cliente);

        if(bultos > 0){
            t = new Aereo(matricula, nombreTransporte, precioBase, bultos, precioCombustible);
        }else
            t = new Maritimo(nombreTransporte, matricula, precioBase, (short)tipoBuque, toneladas);

        hojita.setTransporteUtilizado(t);

        return hojita;
    }
}
