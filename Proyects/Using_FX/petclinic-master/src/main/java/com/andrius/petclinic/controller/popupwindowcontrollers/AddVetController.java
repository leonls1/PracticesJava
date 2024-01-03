package com.andrius.petclinic.controller.popupwindowcontrollers;

import com.andrius.petclinic.controller.mainwindowcontrollers.SceneController;
import com.andrius.petclinic.dao.VetDao;
import com.andrius.petclinic.helpers.UpdateStatus;
import com.andrius.petclinic.model.Veterinarian;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import java.io.IOException;

public class AddVetController {

    @FXML
    private TextField vetFirstName;

    @FXML
    private TextField vetLastName;

    @FXML
    private TextField vetSpeciality;

    @FXML
    private TextField vetAddress;

    @FXML
    private Label alertText;

    @FXML
    private void saveNewVetToDb(ActionEvent event) throws IOException {
        if (validateInputs()) {
            Veterinarian vet = createVetFromInput();
            boolean isSaved = new VetDao().createVet(vet);
            if (isSaved) {
                UpdateStatus.setIsVetAdded(true);
                alertText.setText("Vet is added!");
                delayWindowClose(event);
            }
        }
    }

    private boolean validateInputs() {
        if (vetFirstName.getText().equals("")) {
            alertText.setText("*You must add first name!");
            return false;
        }

        if (vetLastName.getText().equals("")) {
            alertText.setText("*You must add last name!");
            return false;
        }

        if (vetSpeciality.getText().equals("")) {
            alertText.setText("*You must add speciality!");
            return false;
        }

        if (vetAddress.getText().equals("")) {
            alertText.setText("*You must add address!");
            return false;
        }
        return true;
    }

    private Veterinarian createVetFromInput() {
        Veterinarian vet = new Veterinarian();
        vet.setFirstName(vetFirstName.getText());
        vet.setLastName(vetLastName.getText());
        vet.setSpeciality(vetSpeciality.getText());
        vet.setAddress(vetAddress.getText());
        return vet;
    }

    private void delayWindowClose(ActionEvent event) {
        PauseTransition delay = new PauseTransition(Duration.seconds(1));
        delay.setOnFinished(event2 -> closeWindow(event));
        delay.play();
    }

    @FXML
    private void closeWindow(ActionEvent event) {
        SceneController.close(event);
    }
}
