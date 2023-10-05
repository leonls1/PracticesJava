package guicontrolsexample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class PrimaryController implements Initializable{

    @FXML
    private Button btnAccept;
    
    @FXML
    private TextField txt1, txt2,txt3, txt4;
 
            
    
    @FXML
    private void eventButton(ActionEvent event){
       // javax.swing.JOptionPane.showMessageDialog(null, "Hola mundo");
        System.out.println("Me presionaste");
    }
    
    @FXML
    private void eventkey(KeyEvent event){
        Object evt = event.getSource();
        //to know where the event come(which label are we talking about)
        if(evt.equals(txt1)){
            if(!Character.isLetter(event.getCharacter().charAt(0)) && !event.getCharacter().equals(" ")){
                event.consume(); //the event get consumed and anything pass to the textField
                System.out.println("validacion 1");
            }
        }else if(evt.equals(txt2)){
            if(!Character.isDigit(event.getCharacter().charAt(0))){
                event.consume();
                if(event.isConsumed()){
                    System.out.println("validacion 2");
                }
                    
                else{
                    System.out.println("no se esta consumiendo");
                }
                    
            }
        }else if(evt.equals(txt3)){
            if(!Character.isDigit(event.getCharacter().charAt(0)) && !Character.isLetter(event.getCharacter().charAt(0)) && !event.getCharacter().equals(" ")){
                event.consume();
                System.out.println("validacion 3");
            }
        }else if(evt.equals(txt4)){
            if(txt4.getText().length() > 8  ){//the text here wont be longer than 8 characters
                event.consume();
                System.out.println("validacion 4");
            }
        }else 
            System.out.println("no esta andando");
        
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
