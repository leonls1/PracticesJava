/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package formwithfx.controller;

import formwithfx.model.Employee;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author leon
 */
public class createEmployeeController implements Initializable {

    private ArrayList<Employee> employees;
    
    @FXML 
    private TextField txtName, txtLastName, txtSalary;
    
    @FXML
    private TextArea txtObservations;
    
    @FXML
    private Button btnCreate, btnReset;
    
    @FXML
    private ComboBox<String> cboGender;
    
    @FXML
    private void buttonEvent(ActionEvent event){
        Object evt = event.getSource();
        
        if (evt.equals(btnReset)){
            txtName.setText("");
            txtLastName.setText("");
            txtObservations.setText("");
            txtSalary.setText("");
        }else if(evt.equals(btnCreate)){
            //make some validations with the salary and other fields
        }       
    }
    
    @FXML
    private void comboBoxEvent(ActionEvent event ){
        
    }  

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
