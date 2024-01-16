package Task.controller;

import Task.model.Task;
import Task.model.TaskType;
import Task.service.TaskDao;
import Task.service.TaskImp;
import Task.service.TaskTypeDao;
import Task.service.TaskTypeImp;
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
    private ComboBox<TaskType> cboType;

    @FXML
    private TextArea txtDescription;

    @FXML
    private TableView<Task> tasksTable;

    @FXML
    private TableColumn idCol, nameCol, startCol, endCol, importantCol, typeCol;

    private TaskDao taskService;

    private TaskTypeDao taskTypeService;

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

            saveTask();

        } else if (evt.equals(btnUpdate)) {

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

        taskService = new TaskImp();
        taskTypeService = new TaskTypeImp();
        task = new Task();
        getTask();
        getTypes();
    }

    private void setCurrentTask() {
        txtName.setText(task.getName());
        txtDescription.setText(task.getDescription());
        dtpEnd.setValue(task.getEndDate());
        dtpStart.setValue(task.getCreationDate());
        cboType.setValue(task.getTaskType());

    }

    private void deleteTask() {
        taskService.delete(task);
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
        cboType.setDisable(false);

        btnUpdate.setDisable(false);
    }

    private void getTask() {

        List<Task> list = taskService.getAll();

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        importantCol.setCellValueFactory(new PropertyValueFactory<>("important"));
        startCol.setCellValueFactory(new PropertyValueFactory<>("creationDate"));
        endCol.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("taskType"));

        tasksTable.setItems(FXCollections.observableArrayList(list));
        tasksTable.refresh();
    }

    private void getTypes() {
        List<TaskType> list = taskTypeService.getAll();
        cboType.setItems(FXCollections.observableArrayList(list));

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
        loadTask();
        taskService.create(this.task);
        getTask();
    }

    private void loadTask() {
        task.setEndDate(dtpEnd.getValue());
        task.setCreationDate(dtpStart.getValue());
        task.setName(txtName.getText());
        task.setTaskType(cboType.getSelectionModel().getSelectedItem());
        task.setDescription(txtDescription.getText());

        if (radioYes.isSelected()) {
            task.setImportant(true);
        } else {
            task.setImportant(false);
        }

    }

    private void updateTask() {
        loadTask();
        taskService.update(this.task);
        getTask();

    }

}
