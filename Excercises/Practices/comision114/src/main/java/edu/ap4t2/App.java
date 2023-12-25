package edu.ap4t2;

import edu.ap4t2.model.Materia;
import edu.ap4t2.model.Operacion;
import java.util.*;
import java.util.function.*;

/**
 * Hello world!
 *
 */
public class App {
  public static void main(String[] args) {

    Materia mM = new Materia("Matemática");
    Materia mF = new Materia("Física");

    mF.addMateriaCorrelativa(mM);

    /*
     * Operacion suma = (s, d) -> s + d;
     * Operacion resta = (x, z) -> x - z;
     * 
     * System.out.println(suma.operar(5, 6));
     * System.out.println(resta.operar(5, 6));
     */
    /*
     * Comparator<String> compararDescendente = new Comparator<>() {
     * 
     * @Override
     * public int compare(String o1, String o2) {
     * return o2.compareTo(o1);
     * }
     * };
     */

    List<String> lista = new ArrayList<>(List.of("hola", "mundo", "chau"));

    Collections.sort(lista, (String x, String y) -> y.compareTo(x));
    System.out.println(lista);

    Operacion limpiarBlancos = (String x) -> {
      return x.replace(' ', '\u0000');
    };
    // System.out.println(limpiarBlancos.procesar(" hola mundo .... "));

    Operacion pasarAMayusculas = (String x) -> x.toUpperCase();

    // System.out.println(pasarAMayusculas.procesar("hola mundo"));

    Predicate<String> evaluarCadenasMayores20 = x -> x.length() > 20;

    // System.out.println(evaluarCadenasMayores20.test("hola"));
    // System.out.println(evaluarCadenasMayores20.test("hola mundo hola mundo hola
    // mundo"));

    Supplier<Materia> generadorMateria = () -> {
      Materia m = new Materia();
      m.setNombre("Materia por defecto");
      m.setId(Materia.getIdGlobal());
      m.incrementIdGlobal();
      return m;
    };

    Materia miMateria = generadorMateria.get();

    // System.out.println(miMateria);

    Materia m2 = generadorMateria.get();
    // System.out.println(m2);

    BiConsumer<Materia, Materia> imprimirMateria = (m, y) -> {
      System.out.println(m.getNombre());
      System.out.println(y.getNombre());
      return;
    };

    imprimirMateria.accept(m2, miMateria);

    // Function<Materia,Integer> transformarEnMateriasCorrelativas=

    Function<Double, Double> calcularCuadrado = (x) -> Math.pow(x, 2);
    System.out.println(calcularCuadrado.apply(9d));

  }
}
