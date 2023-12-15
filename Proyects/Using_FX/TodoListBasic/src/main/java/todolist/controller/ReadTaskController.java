/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package todolist.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author leon
 */
public class ReadTaskController implements Initializable {

    @FXML
    private Button btnSearch, btnCreate, btnEdit, btnDelete;
    
    @FXML
    private TextField txtName;
    
    @FXML
    private TextArea txtDescription;
    
    @FXML 
    private CheckBox checkBoxImportant;
    
    @FXML
    private ComboBox cboTypes;
    
    @FXML
    private TableView tableViewTask;
    
    @FXML
    private void comboBoxEvent(){
        
    }
    
    @FXML
    private void buttonEvent(){
        
    }   

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
}
