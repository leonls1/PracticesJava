package Task.controller;

import Task.model.Task;
import Task.service.TaskDao;
import Task.service.TaskImp;
import Task.utilities.Validations;
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
import java.util.List;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class MainController implements Initializable {

    @FXML
    private Button btnDelete, btnSave, btnUpdate, btnDetail, btnClear, btnEdit;

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
            deleteTask();
        } else if (evt.equals(btnDetail)) {
            //to do later

        } else if (evt.equals(btnSave)) {
//            if (requiredFields()) {
//                saveTask();
//            }
            saveTask();

        } else if (evt.equals(btnUpdate)) {
//            if (requiredFields()) {
//                updateTask();
//            }
            updateTask();

        } else if (evt.equals(btnEdit)) {
            enableEdit();
        }

    }

    @FXML
    private void mouseEvent(MouseEvent evt) {
        Object obj = evt.getSource();
        if (obj.equals(tasksTable)) {
            btnSave.setDisable(true);
            btnEdit.setDisable(false);
            btnDelete.setDisable(false);

            txtName.setDisable(true);
            dtpEnd.setDisable(true);
            dtpStart.setDisable(true);
            txtDescription.setDisable(true);
            radioNo.setDisable(true);
            radioYes.setDisable(true);

            task = tasksTable.getSelectionModel().getSelectedItem();
            setCurrentTask();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dtpEnd.setValue(LocalDate.now());
        dtpStart.setValue(LocalDate.now());

        service = new TaskImp();
        task = new Task();
        getTask();
    }

    private void setCurrentTask() {
        txtName.setText(task.getName());
        txtDescription.setText(task.getDescription());
        dtpEnd.setValue(task.getEndDate());
        dtpStart.setValue(task.getCreationDate());
        cboType.setValue(task.getType());

    }

    private void deleteTask() {
        service.delete(task);
        clearFields();
        getTask();
        tasksTable.refresh();
    }

    private void enableEdit() {

        txtName.setDisable(false);
        dtpEnd.setDisable(false);
        dtpStart.setDisable(false);
        txtDescription.setDisable(false);
        radioNo.setDisable(false);
        radioYes.setDisable(false);

        btnUpdate.setDisable(false);
    }

    private void getTask() {

        List<Task> list = service.getAll();
        list.forEach(task -> System.out.println(task.toString()));

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        importantCol.setCellValueFactory(new PropertyValueFactory<>("important"));
        startCol.setCellValueFactory(new PropertyValueFactory<>("creationDate"));
        endCol.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));

        tasksTable.setItems(FXCollections.observableArrayList(list));
        tasksTable.refresh();

    }

    private void clearFields() {
        txtDescription.setText("");
        txtName.setText("");
        dtpEnd.setValue(LocalDate.now());
        dtpStart.setValue(LocalDate.now());

        task = new Task();

        btnEdit.setDisable(true);
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);
        btnDetail.setDisable(true);
        btnSave.setDisable(false);

        enableEdit();
    }

    private void saveTask() {
        task.setEndDate(dtpEnd.getValue());
        task.setCreationDate(dtpStart.getValue());
        task.setName(txtName.getText());
        task.setType(0);
        task.setDescription(txtDescription.getText());

        if (radioYes.isSelected()) {
            task.setImportant(true);
        } else {
            task.setImportant(false);
        }

        service.create(this.task);
        getTask();
    }

    private void updateTask() {
        task.setEndDate(dtpEnd.getValue());
        task.setCreationDate(dtpStart.getValue());
        task.setName(txtName.getText());
        task.setType(0);
        task.setDescription(txtDescription.getText());

        if (radioYes.isSelected()) {
            task.setImportant(true);
        } else {
            task.setImportant(false);
        }

        service.update(this.task);
        getTask();
    }

//    private boolean requiredFields() {
//        if (Validations.lenghtRequired(txtName.getText())) {
//            System.out.println("field required");
//            return false;
//        } else {
//            return true;
//        }
//    }
}
