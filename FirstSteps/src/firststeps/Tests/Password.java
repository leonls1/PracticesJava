/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package firststeps.Tests;
import javax.swing.JOptionPane;
/**
 *
 * @author leon
 */
public class Password {
    public static void main(String[] args){
        String contrasenia = "passowrd";
        String pass ="";
        
        while (contrasenia.equals(pass)==false){
            pass = JOptionPane.showInputDialog("Ingrese la contraseña por favor");
            
            if (contrasenia.equals(pass)==false){
            System.out.println("Contraseña incorrecta");
            }
            else{
                System.out.println("Contraseña correcta");
            }
                
        }
    }
}
