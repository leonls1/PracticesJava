/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase2;

import java.util.ArrayList;

/**
 *
 * @author leon
 */
public class Clase2 {

    public static void main(String[] args) {
        //opcion 1
        ToUpperCase toUppercase1 = stringsList -> {
            ArrayList<String> withUpperCase = new ArrayList<>(); //making a new arraylist with my string list
            //parameter
            stringsList.forEach( item -> withUpperCase.add( item.toUpperCase())); // loop the array changig every item for its version on UpperCase
            
            return withUpperCase;
           
        };
        
        
        //opcion 2
        ToUpperCase toUpperCase2 = strings -> {
            ArrayList<String> upperCase = new ArrayList<>(strings);
            upperCase.replaceAll(String::toUpperCase);
            return upperCase;
        };

        ArrayList<String> strings = new ArrayList<>();
        strings.add("uno");
        strings.add("Tres");
        strings.add("DoS");
        //{"uno", "dos", "tres"}
        
        System.out.println("Arreglo inicial");
        strings.forEach(x -> System.out.println(x));
        
        System.out.println("Arreglo con el metodo 1");
        toUppercase1.upper(strings).forEach(x -> System.out.println(x));
        
        System.out.println("Arreglo con el metodo 2");
        toUpperCase2.upper(strings).forEach(x -> System.out.println(x));

    }

    @FunctionalInterface
    interface ToUpperCase {
        ArrayList<String> upper(ArrayList<String> StringList);
    }
    
    static ArrayList<String> transformador (ArrayList<String> StringList,ToUpperCase interface1 ){
        return interface1.upper(StringList);
    }

}
