/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi_v2.model.businessLogic.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.SEQUENCE;
import jakarta.persistence.Id;
import java.util.Date;
import lombok.Data;
import tpi_v2.model.businessLogic.entity.incidentPatternState.State;

@Data
@Entity
@jakarta.persistence.Table(name = "incident")
public class Incident {
   
    @Id 
    @Column( nullable = false, unique = true)   
    @GeneratedValue(strategy=SEQUENCE, generator="IDENTITY")  
    private Long id;
    
    private String title;
    
    private String description;
    
    @Column(name = "entry_date")
    private Date entryDate;
    
    @Column(name = "resolution_date")
    private Date resolutionDate;
    
    private State state;
    
    
    
}
