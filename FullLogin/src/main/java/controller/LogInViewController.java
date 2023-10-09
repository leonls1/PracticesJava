/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author leon
 */
public class LogInViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button btnLogIn;
    
    @FXML
    private TextField txtUser;
    
    @FXML
    private PasswordField txtPassword;
    
    @FXML
    private void eventKey(KeyEvent event){        
        Object evt = event.getSource();
        
        if(evt.equals(txtUser)){//so i can't put any white space
            if(event.getCharacter().equals( " ")){
                event.consume();
            }
            
        }else if(evt.equals(txtPassword)){
           if(event.getCharacter().equals( " ")){
                event.consume();
            } 
        }
        
    }
    
    @FXML
    private void eventAction(ActionEvent event){
        Object evt = event.getSource();
        
        if(evt.equals(btnLogIn)){
            String user = txtUser.getText();
            String password = txtPassword.getText();
            //System.out.println("Logeado");
            if(!user.isBlank()&& !password.isBlank()){                
                if(user.equals("usuario")  && password.equals("contraseña")){
                    System.out.println("logeado");
                }else
                    System.out.println("usuario y/o contranseña incorrecto ");
            }
            
            
            
            
            
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
