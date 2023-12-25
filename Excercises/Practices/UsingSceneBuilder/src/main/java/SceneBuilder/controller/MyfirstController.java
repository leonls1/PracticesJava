package SceneBuilder.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MyfirstController implements Initializable{

    @FXML
    Label saludo = new Label();
    
    @FXML
    Button Btn1 = new Button();
    
    @FXML
    private void Saludar() throws IOException {
        System.out.println("Hola mundo");
        saludo.setText("hola mundo");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       Btn1.setText("Saludar");
    }
}