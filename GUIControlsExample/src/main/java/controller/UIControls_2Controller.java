/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import guicontrolsexample.App;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author leon
 */
public class UIControls_2Controller implements Initializable {

    @FXML
    private CheckBox indeterminatedCheckBox;
    
    @FXML
    private Button btnBackPrimary;
    
    @FXML
    private void mouseEvent(MouseEvent event){
        if(indeterminatedCheckBox.isIndeterminate()){
            System.out.println("esta indeterminado");
        }
        else if(indeterminatedCheckBox.isSelected()){
            System.out.println("Esta seleccionado");
        }
        else 
            System.out.println("No esta seleccionado");
    }
    
    
    @FXML 
    private void actionEvent(ActionEvent event){
       Object evt = event.getSource();
       
       if(evt.equals(btnBackPrimary)){
           System.out.println("Deberia cambiar a la otra pestaña");
       }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
