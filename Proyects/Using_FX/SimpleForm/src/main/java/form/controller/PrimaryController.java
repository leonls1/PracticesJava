package form.controller;

import form.entity.Person;
import form.service.PersonService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable{

    @FXML 
    private Button  btnCreate, btnGetAll, btnClear;
    
    @FXML
    private TextField txtName, txtEmail;
    
    @FXML
    private PasswordField txtPass;
    
    private Person person;
    
    private PersonService service;
    
    @FXML
    private void btnAction(ActionEvent evtent){
        Object evt = evtent.getSource();
        person = new Person();
        
        if(evt.equals(btnCreate)){
            if( !txtName.getText().isEmpty() && !txtEmail.getText().isEmpty() && !txtPass.getText().isEmpty() ){
                person.setEmail(txtEmail.getText());
                person.setPassword(txtPass.getText());
                person.setName(txtName.getText());
                
                service.savePerson(person);
                System.out.println("Person created");
            }else System.out.println("Error");
        }else if(evt.equals(btnGetAll)){            
            
        }else if(evt.equals(btnClear)){
            txtName.setText("");
            txtEmail.setText("");
            txtPass.setText("");
        }
            
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        service = new PersonService();
    }
}
