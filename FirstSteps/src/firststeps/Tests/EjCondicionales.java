/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package firststeps.Tests;

import java.util.Scanner;

/**
 *
 * @author leon
 */
public class EjCondicionales {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la figura de la que quiere calcular el area \n 1. Cuadrado"
                + "\n2: Rectangulo \n3: Triangulo  \n4: Circulo");
        int opcion = sc.nextInt();
        
        switch (opcion) {
            case 1:
                System.out.println("El area es:");
                break;
            default:
                throw new AssertionError();
        }
        
    }
}
