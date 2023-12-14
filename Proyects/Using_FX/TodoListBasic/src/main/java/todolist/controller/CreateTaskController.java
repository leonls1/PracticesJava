
package todolist.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import todolist.model.entity.Task;
import todolist.model.entity.TaskType;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;


public class CreateTaskController implements Initializable {

    //private ArrayList<Task> tasks;    
    private Task task;

@FXML
private Button btnRead, btnReset, btnCreate;

    @FXML
    private ComboBox<TaskType> cboType;

    @FXML
    private RadioButton radioImportant, radioNotImportant;

    @FXML
    private TextField txtName;

    @FXML
    private TextArea txtDescription;

    @FXML
    private DatePicker datePickBegin, datePickEnd;

    @FXML
    private void comboBoxEvent(ActionEvent event) {
        Object evt = event.getSource();
    }

    @FXML
    private void btnEvent(ActionEvent event) {
        Object evt = event.getSource();

        if (evt.equals(btnReset)) {
            txtDescription.setText("");
            txtName.setText("");

        } else if (evt.equals(btnCreate)) {
            if (validationOnCreate()) {

                creatingTask();
                System.out.println(task);

            }
        } else if (evt.equals(btnRead)) {
            try {
                changeToRead(event);
            } catch (IOException e) {
                System.out.println("NO existe el achivo");
            }

        }
    }

    private void creatingTask() {
        boolean isImportant = radioImportant.isSelected();

        if (datePickEnd.getValue() == null) {
            if (datePickBegin.getValue() == null) {
                task = new Task(txtName.getText()
                        , txtDescription.getText()
                        , LocalDate.now()
                        , isImportant);
            } else {
                task = new Task(txtName.getText()
                        , txtDescription.getText()
                        , datePickBegin.getValue()
                        , isImportant);       
            }
        } else if (datePickBegin.getValue() == null) {
            task = new Task(txtName.getText()
                        , txtDescription.getText()
                        ,  LocalDate.now()
                        , datePickEnd.getValue()
                        , isImportant); 

        } else {
            task = new Task(txtName.getText()
                        , txtDescription.getText()
                        , datePickBegin.getValue()
                        , datePickEnd.getValue()
                        , isImportant); 
        }         
        
    }

    private boolean validationOnCreate() {
        if (!(datePickBegin.getValue() == null) && !(datePickEnd.getValue() == null)) {
            if (datePickBegin.getValue().isAfter(datePickEnd.getValue())) {
                System.out.println("The start of the task can't be after the end of it");
                return false;
            }
        }
        if (txtName.getText().isBlank()) {
            System.out.println("The name of the task can't be empty");
            return false;
        }

        return true;
    }

    private void changeToRead(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/todolist/ReadTask.fxml"));
        Scene readView = new Scene(root);

        Stage window = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

        window.setScene(readView);
        window.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {       
    }
    
    

}
//