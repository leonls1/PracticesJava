/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package firststeps.Tests;

import java.util.Scanner;
import javax.swing.*;

/**
 *
 * @author leon
 */
public class EjCondicionales {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la figura de la que quiere calcular el area \n 1.Cuadrado"
                + "\n2: Rectangulo \n3: Triangulo  \n4: Circulo");
        int opcion = sc.nextInt();
        
        switch (opcion) {
            case 1:
                int lado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el lado"));
                System.out.println("El area es:"+ (lado*lado));
                break;
            case 2:
                int base = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la base"));
                int altura = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la altura"));
                System.out.println("El area es:" + (base*altura));
                break;
            case 3:
                 base = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la base"));
                 altura = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la altura"));
                System.out.println("El area es:"+ (base*altura/2));
                break;
            case 4:
                int radio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el radio"));
                System.out.println("El area es:"+ (3.14*Math.pow(radio, 2)));
                break;
            default:
                System.out.println("Opcion erronea");
        }
        
    }
}
