/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

/**
 * FXML Controller class
 *
 * @author leon
 */
public class UIControls_2Controller implements Initializable {

    @FXML
    private CheckBox indeterminatedCheckBox;

    @FXML
    private Button btnBackPrimary;

    @FXML
    private RadioButton radio1, radio2, radio3;

    @FXML
    private ToggleGroup grpImg;

    @FXML
    private ImageView containerImg;

    @FXML
    private ComboBox<String> cboN, cboE;

    @FXML
    private void comboBoxEvent(ActionEvent event) {
        Object evt = event.getSource();
        
        if(evt.equals(cboE)){
            System.out.println(cboE.getSelectionModel().getSelectedItem());
        }else if(evt.equals(cboN)){
            System.out.println(cboN.getSelectionModel().getSelectedItem());
        }
    }

    @FXML
    private void mouseEvent(MouseEvent event) {
        if (indeterminatedCheckBox.isIndeterminate()) {
            System.out.println("esta indeterminado");
        } else if (indeterminatedCheckBox.isSelected()) {
            System.out.println("Esta seleccionado");
        } else {
            System.out.println("No esta seleccionado");
        }
    }

    @FXML
    private void actionEvent(ActionEvent event) {
        Object evt = event.getSource();

        if (evt.equals(btnBackPrimary)) {
            System.out.println("Deberia cambiar a la otra pestaña");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        radio1.setUserData("img1");
        radio2.setUserData("img2");
        radio3.setUserData("img3");

        grpImg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if (grpImg.getSelectedToggle() != null) { //valida primero que no este vacio, que se haya seleccionado algun raido button {
                    System.out.println("/images/" + grpImg.getSelectedToggle().getUserData().toString() + ".jpg");
                    // Image image = new Image(getClass().getResourceAsStream("images/" + grpImg.getSelectedToggle().getUserData().toString() + ".jpg"));
                    //containerImg.setImage(image);
                }
            }
        });

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, new String[]{"masculino", "femenino", "otro"});//asignandole componentes a mi arraylist
        cboN.getItems().addAll(list); //agrenado ahora si me mi arraylist al cbo
        cboE.getItems().add("item1");
        cboE.getItems().add("item2");
        cboE.getItems().add("item3");
    }

}
