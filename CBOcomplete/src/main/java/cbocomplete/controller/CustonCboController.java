/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cbocomplete.controller;

import cbocomplete.model.Person;
import cbocomplete.utilities.PersonConverter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author leon
 */
public class CustonCboController implements Initializable {
    
    @FXML
    TextField textSearch;
    
    @FXML
    Button btnSearch;
    
    @FXML
    ComboBox<Person> cboPerson;
    
    @FXML
    TextArea textPerson;
    
    @FXML
    private void comboboxEvents(ActionEvent event){
        
        Object evt = event.getSource();
        
        if (evt.equals(cboPerson)) {
            textPerson.setText(cboPerson.getSelectionModel().getSelectedItem().toString());
            
        }else if(evt.equals(btnSearch)){
            String id = textSearch.getText();
            
            try {
                int idSearch = Integer.parseInt(id);
                int indexSearch = getSelectedIndex(idSearch, cboPerson);
                //looking if i get a result != -1 so i can load that person in my cbo
                if(indexSearch != -1){
                    cboPerson.getSelectionModel().select(indexSearch);
                }else
                    //otherwise the person couldn't be found
                    System.out.println("NO se ha encontrado una persona con ese id");
                    

                
                
            } catch (Exception e) {
                System.out.println("Error de formato, ingrese un valor numerico como id");
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cboPerson.getItems().addAll(createCollectionPersons());
        cboPerson.setConverter(new PersonConverter());
        }    
    
     private ArrayList<Person> createCollectionPersons(){
        
        ArrayList<Person> persons = new ArrayList<>();

        persons.add(new Person(1, "José", "Perez", "Cedula de Ciudadania", "10457772323", "1994-05-09", "Masculino", "jose@gmail.com", "9876765"));
        persons.add(new Person(2, "Juan", "Lopez", "Cedula de Ciudadania", "8740823", "1995-03-01", "Masculino", "juan@gmail.com", "3766765"));
        persons.add(new Person(3, "Jorge", "Martinez", "Cedula de Ciudadania", "7345345", "1996-04-19", "Masculino", "jorge@gmail.com", "4756787"));
        persons.add(new Person(4, "Miguel", "Rodriguez", "Cedula de Ciudadania", "4678987", "1997-07-20", "Masculino", "miguel@gmail.com", "5467676"));
        persons.add(new Person(5, "Andrea", "Suarez", "Cedula de Ciudadania", "1234765", "1998-08-21", "Femenino", "andrea@gmail.com", "8767676"));
        persons.add(new Person(6, "Maria", "Hernandez", "Cedula de Ciudadania", "3456765", "1999-09-30", "Femenino", "maria@gmail.com", "3829898"));
        persons.add(new Person(7, "Sofia", "Aponte", "Cedula de Ciudadania", "2345098", "2000-01-20", "Femenino", "sofia@gmail.com", "4346575"));
        persons.add(new Person(8, "Leticia", "Smith", "Cedula de Ciudadania", "3678654", "1950-12-12", "Femenino", "leticia@gmail.com", "5558798"));
        persons.add(new Person(9, "Amanda", "Salas", "Cedula de Ciudadania", "4654234", "1960-11-11", "Femenino", "amanda@gmail.com", "6669809"));
        persons.add(new Person(10, "Martina", "Salazar", "Cedula de Ciudadania", "2345654", "1970-04-09", "Femenino", "martina@gmail.com", "7893434"));
        
        return persons;
    
    }
     
    private int getSelectedIndex(int id, ComboBox<Person> cbo){
        ObservableList<Person> list = cbo.getItems();
        boolean state = true;
        int i = 0, index = -1, size = list.size(); 
        
        while(state && i < size){
            if(list.get(i).getId() == id){
                state = false;
                index = i;
            }else
                i++;
        }
        
        return index;
    }
}
