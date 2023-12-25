/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cbocomplete.model;

/**
 *
 * @author leon
 */
public class Country {
    private int id;
    private String country;
    private String city;

    public Country() {
    }

    public Country(int id, String country, String city) {
        this.id = id;
        this.country = country;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public String toString(){
        return "id:" + getId() + "\n" +
                "country: " + getCountry() + "\n" +
                "city: " + getCity();
    }
    
    
}
