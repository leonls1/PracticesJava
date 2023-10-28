/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package formwithfx.controller;

import formwithfx.model.Employee;
import formwithfx.model.Gender;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
            Employee employee = new Employee(txtName.getText(), txtLastName.getText(),Gender.OTHER /*cboGender.getSelectionModel().selectedItemProperty()*/, txtObservations.getText(), Integer.parseInt( txtSalary.getText()));
            System.out.println("Empleado creado correctamente"); 
            employees.add(employee);
            
            employees.forEach(emp -> System.out.println(emp.toString()) );
        }       
    }
    
    @FXML
    private void comboBoxEvent(ActionEvent event ){
        Object evt = event.getSource();
        
        if(evt.equals(cboGender)){
            System.out.println("El genero seleccionado es: " + cboGender.getSelectionModel().getSelectedItem());
        }
    }  

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> genres = FXCollections.observableArrayList(
                "MALE",
                "FEMALE",
                "OTHER");
        
        cboGender.getItems().setAll(genres);
        cboGender.getSelectionModel().selectFirst();
        employees = new ArrayList<>();
    }    
    
}
