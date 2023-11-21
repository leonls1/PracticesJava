/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.businessLogic.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.SEQUENCE;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "notification")
public class Notification {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=SEQUENCE, generator="IDENTITY")  
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "incident")
    private Long id_incident;
    
    private String description;
    
    private String contact;
    
    private boolean contactType;
    
}
