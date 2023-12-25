/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaBackEndReview1.dto;

import lombok.Data;

/**
 *
 * @author leon
 */
@Data
public class dtoHuman {

    private int DNI;
    
    private String name;
    
    private String lastName;
    
    private boolean sex;

    public dtoHuman() {
    }

    public dtoHuman(int DNI, String name, String lastName, boolean sex) {
        this.DNI = DNI;
        this.name = name;
        this.lastName = lastName;
        this.sex = sex;
    }
    
    
}
