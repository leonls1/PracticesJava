/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package form.javafxcrud.controller;

import form.javafxcrud.data.AppQuery;
import form.javafxcrud.model.Student;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


public class StudentController implements Initializable {

    private final AppQuery query = new AppQuery();
       
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
    public TableView<Student> tableView;
    
    @FXML
    public TableColumn<Student, Integer> colId ;
    
    @FXML
    public TableColumn<Student, String> colFirtsName;  
    
    @FXML    
    public TableColumn<Student, String> colMiddleName;  
    
    @FXML
    public TableColumn<Student, String> colSurname;  
    
    private Student student;
            
    @FXML
    private void addStudent(){
        Student stu = new Student(
                fieldFirstName.getText(),
                fieldMiddleName.getText(),
                fieldSurname.getText());
        
        query.addStudent(stu);
    }
    
    @FXML
    private void btnEvent(ActionEvent e){
        Object evt = e.getSource();
        
        if(evt.equals(btnDelete)){
            
        }
        
    }
    
    @FXML
    private void mouseClicked(MouseEvent mouseEvent){
        //Object evt = e.getSource();
        
        try {
            Student stu = tableView.getSelectionModel().getSelectedItem();
            student = stu;
            fieldFirstName.setText(student.getFirstName());
            fieldMiddleName.setText(student.getMiddleName());
            fieldSurname.setText(student.getSurname());
            
            btnDelete.setDisable(false);
            btnUpdate.setDisable(false);
            btnSave.setDisable(true);
            
        } catch (Exception e) {
        }
    }
    
    @FXML
    private void getStudents(){
        ObservableList list = query.getStudents();
        
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colFirtsName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colMiddleName.setCellValueFactory(new PropertyValueFactory<>("middleName"));
        colSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        
        
        tableView.setItems(list);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        getStudents();
    }    
    
}
