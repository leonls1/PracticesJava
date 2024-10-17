package pc.leon.Ejercicios.abogados;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EstudioJuridico {
    private List<Abogado> abogados;
    private List<Causa> causas;


    public EstudioJuridico() {
        abogados = new ArrayList<>(); causas = new ArrayList<>();
    }

    // - Abrir una causa. Este metodo debe seleccionar el abogado que tiene que llevar la causa, según el fuero que
    //corresponde y que tenga mayor disponibilidad (es decir, con menor cantidad de causas abiertas), incorporando la
    //causa a la lista de causas del abogado. Si hubiese más de un abogado con el menor número de causas abiertas,
    //se le asignará a cualquiera de ellos.
    public void abrirCausa(Causa causa) {
        List<Abogado> abogadosParaElFueroSeleccionado = obtenerAbogadosSegunFuero(causa.getFuero());
        if (abogadosParaElFueroSeleccionado != null && !abogadosParaElFueroSeleccionado.isEmpty()) {

            /*
            int menorCantidadCausasAbiertas = abogadosParaElFueroSeleccionado.get(0).obtenerCausasAbiertas();

            //primero obtengo el minimo numero de causas que exista
            for(Abogado abogado : abogadosParaElFueroSeleccionado){
                int causasAbiertas = abogado.obtenerCausasAbiertas();
                if(causasAbiertas < menorCantidadCausasAbiertas) menorCantidadCausasAbiertas = causasAbiertas;
            }*/

            //version alternativa mejorada para obtner la menora cantidad de causas abiertas de los abogados
            int menorCantidadCausasAbiertas = abogadosParaElFueroSeleccionado
                    .stream()
                    .mapToInt(abogado -> abogado.obtenerTotalCausasAbiertas())
                    .min()
                    .orElseThrow();

            //ahora, de existir mas de un abogado con ese numero de causas los junto en una lista cosa de despues
            //elegir uno por un random

            List<Abogado> abogadosConMenosCausas = abogadosParaElFueroSeleccionado
                    .stream()
                    .filter(abogado -> abogado.obtenerTotalCausasAbiertas() == menorCantidadCausasAbiertas)
                    .collect(Collectors.toList());

            //obtener un numero aleatorio para los n abogados en el arreglo
            Random random = new Random();
            int numeroAleatorio = random.nextInt(abogadosConMenosCausas.size());

            //con el numero random obtenido entonces a ese abogado le agrego la causa
            abogadosConMenosCausas.get(numeroAleatorio).añadirCausa(causa);

            System.out.println("se añadio la causa correctamente ");

        } else {
            System.out.println("NO hay abogados disponibles para ese fuero");
        }

    }

    private List<Abogado> obtenerAbogadosSegunFuero(int fuero) {
        return (fuero == 1) ?
                abogados.stream()
                        .filter(abogado -> abogado instanceof Civil)
                        .collect(Collectors.toList()) ://else
                abogados.stream().filter(abogado -> abogado instanceof Penalista).collect(Collectors.toList());

    }

    // - Cerrar una causa a partir de un número.
    public void cerrarCausa(String numeroCausa) {
        //esto va a ser mas largo de lo que me imaginaba

        //buscar primero todas las causas que esten abiertas, de toooodos los abogados que tengo claro
        List<Causa> causasAbiertas = obtenerTodasLasCausasAbiertas();

        //buscar la causas y cerrala
        for (Causa causa : causasAbiertas) {
            if (causa.getNumero().equalsIgnoreCase(numeroCausa)) {
                causa.setState(2);
                System.out.println("causa cerrada exitosamente");
                return;
            }
        }
    }

    private List<Causa> obtenerTodasLasCausasAbiertas() {
        List<Causa> causasAbiertas = new ArrayList<>();
        abogados.forEach(abogado ->
                causasAbiertas.addAll(abogado.obtenerCausasAbiertas()));

        return causasAbiertas;
    }

    // - Liquidar haberes de un abogado identificado por su número de documento.
    public float liquidarHaberesPorDocumento(int documento) {
        for (Abogado abogado : abogados) {
            if (abogado.getNroDocumento() == documento) {
                return abogado.calcularHaberes();
            }
        }
        System.out.println("No existe el abogado con ese documento");
        return 0;
    }
    //cargar causas, solucion 1
    public void cargarCausas(URI path){
        File file = new File(path);
        try {
            Scanner sc = new Scanner(file);
            String line = "";
            //buscando en el archivo hasta llegar a las causas
            while(sc.hasNextLine()){
                line = sc.nextLine();
                if(!line.equalsIgnoreCase("Causas")){
                    continue;
                }else{
                    break;
                }
            }
            while(sc.hasNextLine()){
                line = sc.nextLine();
                String[] datos = line.split(";");
                //depues de llegar hasta las causas ahora puedo analizarlas
                if(datos.length != 6) {
                    System.out.println("Linea de datos mal formada" + line);
                    continue;
                }
                try {
                    //numero;demandante;estado;sentencia;monto;fuero
                    String numero =datos[0];
                    String demandante = datos[1];
                    int estado = Integer.parseInt(datos[2]);
                    int sentencia = Integer.parseInt(datos[3]);
                    float monto = Float.parseFloat(datos[4]);
                    int fuero = Integer.parseInt(datos[5]);

                    Causa causa = new Causa(numero, demandante, estado, sentencia, fuero, monto);
                    causas.add(causa);
                    System.out.println("causa añadida");

                } catch (NumberFormatException e) {
                    System.out.println("NO se ha podido castear a ese tipo de numero");
                    throw new RuntimeException(e);
                }
          }

        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el achivo indicado");
            throw new RuntimeException(e);
        }
    }

    //cargar causas aplicando lo que hizo el profe
    public void cargarCausas2(URI path){

    }

}

