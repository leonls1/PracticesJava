package com.andrius.petclinic.controller.mainwindowcontrollers;

import com.andrius.petclinic.helpers.SceneName;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;

/**
 * Code created by Andrius on 2020-09-28
 */
public class SearchDashController {

    protected static String searchValue = "";

    @FXML
    private Label title;

    @FXML
    private Label date;

    @FXML
    private TextField searchField;

    @FXML
    private Label searchQueryInfo;

    @FXML
    private Label searchKeyword;

    @FXML
    private void initialize() {
        title.setText(SceneName.SEARCH.getName());
        date.setText(LocalDate.now().toString());
        searchQueryInfo.setText("Search results for:");
        searchKeyword.setText(searchValue);
    }

    @FXML
    private synchronized void getSearchResults(ActionEvent event)  throws IOException {
        String searchTerm = searchField.getText();
        if(!searchTerm.equals("")) {
            searchValue = searchTerm;
            SceneController.getSearchScene(event);
        }
    }

    @FXML
    void showDashboard(ActionEvent event) throws IOException {
        SceneController.getMainScene(event);
    }

    @FXML
    void showVisitScreen(ActionEvent event) throws IOException {
        SceneController.getVisitScene(event);
    }

    @FXML
    void showPetScreen(ActionEvent event) throws IOException {
        SceneController.getPetsScene(event);
    }

    @FXML
    void showVetScreen(ActionEvent event) throws IOException {
        SceneController.getVetsScene(event);
    }

    @FXML
    void exitProgram(ActionEvent event) {
        SceneController.close(event);
    }
}
