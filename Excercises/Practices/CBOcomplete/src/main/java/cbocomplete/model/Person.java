/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cbocomplete.model;

/**
 *
 * @author leon
 */
public class Person {
    private int id;
    private String name;
    private String lastName;
    private String idType;
    private String idNumber;
    private String dateOfBirth;
    private String gender;
    private String email;
    private String phone; 

    public Person() {
    }

    public Person(int id, String name, String lastName, String idType, String idNumber, String dateOfBirth, String gender, String email, String phone) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.idType = idType;
        this.idNumber = idNumber;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getIdType() {
        return idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    @Override
    public String toString(){
        return  "id:" + getId() + "\n" +
                "tipo identificacion: " + getIdType() + "\n" +
                "Numero de indetificacion: " + getIdNumber() + "\n" +
                "Nombre completo: " + getName() + " " + getLastName() + "\n" +
                "Fecha de nacimiento: " + getDateOfBirth() + "\n" +
                "Genero: " + getGender() + "\n" +
                "Telefono: " + getPhone() + "\n" +
                "Email: " + getEmail() + "\n" ;
    }
    
    
    
    
}
