package Task.controller;


import Task.model.Task;
import Task.service.TaskDao;
import Task.service.TaskImp;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.List;
import javafx.collections.FXCollections;

public class MainController implements Initializable {


    @FXML
    private Button btnDelete, btnSave, btnUpdate, btnDetail, btnClear;

    @FXML
    private TextField txtName;

    @FXML
    private DatePicker dtpStart, dtpEnd;

    @FXML
    private RadioButton radioYes, radioNo;

    @FXML
    private ComboBox cboType;

    @FXML
    private TextArea txtDescription;

    @FXML
    private TableView<Task> tasksTable;

    @FXML
    private TableColumn idCol, nameCol, startCol, endCol, importantCol, typeCol;
    
    private TaskDao service;
    
    private Task task;

    @FXML
    private void btnEvent(ActionEvent event) {
        Object evt = event.getSource();

        if (evt.equals(btnClear)) {
            clearFields();

        } else if (evt.equals(btnDelete)) {

        } else if (evt.equals(btnDetail)) {

        } else if (evt.equals(btnSave)) {
            saveTask();

        } else if (evt.equals(btnUpdate)) {

        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        service = new TaskImp();
        task = new Task();
        getTask();
    }

    private void getTask() {
       /* List<Task> list = service.getAll();
        System.out.println(list.size());
        list.forEach(task -> System.out.println(task.toString()));

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
         importantCol.setCellValueFactory(new PropertyValueFactory<>("important")); // Uncomment if "important" is a property in Task
        startCol.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        endCol.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));

        tasksTable.setItems(FXCollections.observableArrayList(list));
*/
    }

    private void clearFields() {
        txtDescription.setText("");
        txtName.setText("");
        dtpEnd.setValue(LocalDate.now());
        dtpStart.setValue(LocalDate.now());
    }
    
    private void saveTask(){
        task.setEndDate(dtpEnd.getValue());
        task.setCreationDate(dtpStart.getValue());
        task.setName(txtName.getText());
        task.setType(0);
        task.setDescription(txtDescription.getText());
        
        if(radioYes.isSelected()){
            task.setImportant(true);
        }else task.setImportant(false);
        
        service.create(this.task);
    }
    

}
