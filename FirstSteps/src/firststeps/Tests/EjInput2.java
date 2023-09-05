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
public class EjInput2 {
    public static void main(String[] args){
        System.out.println("Hello word");
        
        String name = JOptionPane.showInputDialog("Ingrese su nombre");
        int age = Integer.parseInt(JOptionPane.showInputDialog("please; input your age"));
        System.out.println("Tu nombre es: " + name+ " y tu edad es:" + age);
    }
}
