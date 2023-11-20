/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.businessLogic.entity;

import java.util.Date;

/**
 *
 * @author leon
 */
public class Incident {
    private Long id  ;
    
    private Date estimatedDate;
    
    private Date entryDate;
    
    private Date realDate;
    
    private String description;
    
    //enums StateType --> state pattern
    
    private Long servicio;

    //fk --> Clinte.cuil/cuil
    private String CUIL_CUIT;
   
    //fk --> Servicio
    private Long id_service;
    
    
    
    
}
