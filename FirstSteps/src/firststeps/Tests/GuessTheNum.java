/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package firststeps.Tests;
import javax.swing.*;
/**
 *
 * @author leon
 */
public class GuessTheNum {
    public static void main(String[] args){
        int numero = (int)(Math.random()*100);
        System.out.println("Adivina el numero entre 0 y 100");
        System.out.println(numero);
        int intentos=1;
        int opcion= Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero entre 0 y 100"));
        
        while(opcion != numero){
            if(numero> opcion){
                System.out.println("Un poco mas alto");
            }
            if(numero<opcion){
                System.out.println("Un poco mas bajo");
            }          
            opcion= Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero entre 0 y 100"));
            intentos++;
        }
        System.out.println("Acertaste el numero en: "+ intentos);
        
    }
}
