/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.businessLogic.entity;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Client {
    
    private String CUIL_CUIT;
    
    private String phone;
    
    private String email;
    
    private Long id_corporateName;
    
}