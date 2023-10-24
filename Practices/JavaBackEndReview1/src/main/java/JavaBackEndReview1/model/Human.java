/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaBackEndReview1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.Id;

/**
 *
 * @author leon
 */
@Entity
@Data
@Table(name = "Human")
public class Human {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "dni")
    private int DNI;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "lastName")
    private String lastName;
    
    @Column(name = "sex")
    private boolean sex;
    
    public Human(){       
    }

    public Human(int DNI, String name, String lastName, boolean sex) {
        this.DNI = DNI;
        this.name = name;
        this.lastName = lastName;
        this.sex = sex;
    }
    
    
    
            
}
