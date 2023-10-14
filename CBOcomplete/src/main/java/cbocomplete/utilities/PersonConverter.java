/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cbocomplete.utilities;

import cbocomplete.model.Person;
import javafx.util.StringConverter;

/**
 *
 * @author leon
 */
public class PersonConverter extends StringConverter<Person>{

    @Override
    public String toString(Person person) {
        return person == null ? null :  person.getName() + "" + person.getLastName();
    }

    @Override
    public Person fromString(String string) {
        return null; //for now it just return null because my cbo isn't editable
    }
    
}
