/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase3;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 * @author leon
 */
public class Exercice2  {
    /*Implementar un método que reciba como parámetro una lista de strings y un entero "n". El
método debe devolver un String que concatene separando por coma y espacio todas las
palabras, en la lista, que tengan más de "n" caracteres.

    */
    
    public static void main(String[] args) {
        
    }

    static String tarea2(ArrayList<String> listita, int n){
        return listita.stream().filter(elem -> elem.length() > n ).collect(Collectors.joining());

    }
    
   
    
}
