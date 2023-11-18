/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Entity;

import model.enums.EmployeeType;
import java.util.Date;

public class Employee {
    private Long id; //legajo
    
    private String name;
    
    private String lastName;
    
    private Date birthDate;
    
    private String email;
    
    private String phone;
    
    private Date entryDate;
    
    private EmployeeType employeeType; 
         
}
