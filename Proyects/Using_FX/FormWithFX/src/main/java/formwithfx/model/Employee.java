/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formwithfx.model;

/**
 *
 * @author leon
 */
public class Employee {

    private String name;
    private String lastName;
    private Gender gender;
    private String Observations;
    private double salary;
    private int id;

    public Employee(String name, String lastName, Gender gender, String Observations, double salary) {
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.Observations = Observations;
        this.salary = salary;
    }
    
    @Override
    public String toString(){
        return      "Nombre: " + name + "\n" +
                    "Apellido: " + lastName + "\n" +
                    "Oberservaciones: " +  Observations + "\n" +
                    "Salario: " + salary + "\n" ;
    }

    
}
