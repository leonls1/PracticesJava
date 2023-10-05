package guicontrolsexample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

public class PrimaryController implements Initializable{

    @FXML
    private Button btnAccept;
    
    @FXML
    private Label txtletters, txtnumbers, txtpass,txtall;
    
    @FXML
    private void eventButton(ActionEvent event){
       // javax.swing.JOptionPane.showMessageDialog(null, "Hola mundo");
        System.out.println("Me presionaste");
    }
    
    @FXML
    private void eventkey(KeyEvent event){
        Object evt = event.getSource();
        
        //if(evt.equals())
        
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnAccept = new Button();
    }
}
