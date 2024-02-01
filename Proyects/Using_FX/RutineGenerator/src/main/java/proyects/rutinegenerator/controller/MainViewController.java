/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package proyects.rutinegenerator.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import proyects.rutinegenerator.model.Rutine;

public class MainViewController implements Initializable {

    @FXML
    private Button btnGenerate;

    @FXML
    private TableView<Rutine> tableRutine;

    @FXML
    private ComboBox<String> cboRutineType;
    
    @FXML
    public void cboEvent(ActionEvent evt){
        
    }
    
    @FXML
    public void btnEvent(ActionEvent evt){
        
    }
        
    @FXML
    public void mouseEvent(MouseEvent evt)

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
