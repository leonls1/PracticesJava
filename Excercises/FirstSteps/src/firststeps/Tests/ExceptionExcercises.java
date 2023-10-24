/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package firststeps.Tests;
import java.util.*;
/**
 *
 * @author leon
 */
public class ExceptionExcercises {
    public static void main(String[] args) {

        
        try {
                    Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el primer numero");
        int num1 = sc.nextInt();
        System.out.println("Ingrese el segundo numero");
        int num2 = sc.nextInt();
            System.out.println(num1/num2);
        } catch (ArithmeticException e) {
             System.out.println("No puedes ingresar un cero como valor");
        } catch(InputMismatchException e){
            System.out.println("No puedes ingresar algo que no sea un numero entero (sin coma)");
        }finally{
            System.out.println("Programa finalizado");
        }
       
            
    }
    
    class EsCero extends ArithmeticException{

        public EsCero(String message) {
            super(message);
        }
        
    }
}
