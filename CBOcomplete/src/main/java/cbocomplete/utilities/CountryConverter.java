/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cbocomplete.utilities;

import cbocomplete.model.Country;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import javafx.util.StringConverter;

/**
 *
 * @author leon
 */
public class CountryConverter extends StringConverter<Country>{

    ComboBox<Country> cbo ;
    
    public CountryConverter(ComboBox<Country> cbo){
        this.cbo = cbo;
    }
    
    @Override
    public String toString(Country country) {
        return country == null ? null : country.getCountry();
    }
    
    private void updateCell(){
    
        cbo.setCellFactory(new Callback<ListView<Country>, ListCell<Country>>() {
            @Override
            public ListCell<Country> call(ListView<Country> param) {
                
                ListCell cell = new ListCell<Country>(){
                
                    @Override
                    public void updateItem(Country item, boolean empty){
                        super.updateItem(item, empty);
                        if(empty){
                            setText("");
                        }else{
                            setText(item.getCountry());
                        }
                    }
                
                };

                return cell;
            }
        });
    
    }

    @Override
    public Country fromString(String string) {
        Country country = this.cbo.getValue();
        
        if(country !=  null){
            country.setCountry(string);
            updateCell(); 
            return country;
            
        }else{
            Country newCountry = new Country(cbo.getItems().size() +1, string,"");
            return newCountry;
        }              
    }
    
}
