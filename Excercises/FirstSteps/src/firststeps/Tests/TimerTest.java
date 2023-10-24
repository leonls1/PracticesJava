/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package firststeps.Tests;
import javax.swing.Timer;
import java.awt.event.*;
import java.util.*;
import javax.swing.JOptionPane;
import java.awt.Toolkit;
//trying a timer with concept of interface at the same time
public class TimerTest {
    public static void main(String[] args) {
        Evento listener = new Evento();
        
        Timer miteporizador= new Timer(5000, listener);
        
        miteporizador.start();
        
        JOptionPane.showInternalMessageDialog(null, "Hace click en aceptar para finalizar");
        
        System.exit(0);
        
        
    }
     static class Evento implements ActionListener{
         
        Date ahora = new Date();
        
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Te muestro la hora cada 5 seg: "+ ahora );
            Toolkit.getDefaultToolkit().beep();
        }
            
        
    }
    
   
}
