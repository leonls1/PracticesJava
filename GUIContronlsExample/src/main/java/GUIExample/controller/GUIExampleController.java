/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIExample.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javax.swing.JOptionPane;

/**
 *
 * @author leon
 */

public class GUIExampleController implements Initializable{

    @FXML
    private Button btnAccept;
    
    @FXML
    private void eventButton(ActionEvent event){
        JOptionPane.showMessageDialog(null, "Hola mundo");
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnAccept = new Button();
    }
    
}
