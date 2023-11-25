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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;
import lombok.Data;
import model.businessLogic.entity.incidentStatePatterns.Finished;
import model.businessLogic.entity.incidentStatePatterns.State;

@Data
@Entity
@Table(name = "incident")
public class Incident {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=SEQUENCE, generator="IDENTITY")    
    private Long id  ;
    
    @Column(name = "estimated_date")
    private Date estimatedDate;
    
    private Date entryDate;
    
    private Date realDate;
    
    private String description;
    
    private State state;
    
    @ManyToOne
    @JoinColumn(name = "client")
    private Client CUIL_CUIT; 
       
    @ManyToOne
    @JoinColumn(name = "service")
    private Service service;
    
    @OneToMany(mappedBy = "problem")
    private List<Problem> problems ;
    
    @OneToMany(mappedBy = "notification")
    private List<Notification> notification ;

    public void setState(State state) {
    }
}