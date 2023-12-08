package clase3;

import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

public class Exercice1 {
    //Implemente un método que reciba como parámetro una lista de strings y devuelva una nueva
//lista con los strings en mayúscula.

    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("uno");
        lista.add("dos");
        lista.add("trES");
        
        System.out.println(lista);
        toUpperCase(lista).stream().forEach(System.out::println);
        
        //lista.forEach(String);
    }
    //a --> A
/*
    static ArrayList<String> metodito1(ArrayList<String> listita) {
        return listita.stream().map(String::toUpperCase).collect(Collectors.toList() );

         
    }
*/
        static ArrayList<String> toUpperCase(ArrayList<String> listita) {
        ArrayList<String> lista = new ArrayList<>();

        listita.stream().forEach(i -> lista.add(i.toUpperCase()));
        return lista;

    }
        
        static List<String> toUpper(ArrayList<String> listaEntrada){
            return listaEntrada.stream().map(item -> item.toUpperCase())
                    .collect(Collectors.toList());
        }
}
