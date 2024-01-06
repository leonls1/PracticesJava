/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package form.javafxcrud.controller;

import form.javafxcrud.data.AppQuery;
import form.javafxcrud.model.Student;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class StudentController implements Initializable {

    private AppQuery query = new AppQuery();
       
    @FXML
    public TextField fieldFirstName;
    
    @FXML
    public TextField fieldMiddleName;
    
    @FXML
    public TextField fieldSurname;
    
    @FXML
    public Button btnNew;
    
    @FXML
    public Button btnUpdate;
    
    @FXML
    public Button btnSave;
    
    @FXML
    public Button btnDelete;
    
            
    @FXML
    private void addStudent(){
        Student stu = new Student(
                fieldFirstName.getText(),
                fieldMiddleName.getText(),
                fieldSurname.getText());
        
        query.addStudent(stu);
    } 
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
