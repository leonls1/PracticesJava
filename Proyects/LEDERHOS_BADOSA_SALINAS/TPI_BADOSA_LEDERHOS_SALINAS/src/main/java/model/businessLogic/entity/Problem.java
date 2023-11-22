/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.businessLogic.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;


@Data
@Entity
@Table(name = "problem")
public class Problem {
    
    @ManyToOne 
    @JoinColumn(name = "incident")
    private Long incident_id;
    
    @ManyToOne 
    @JoinColumn(name = "problem_type")
    private Long id_problemType;
    
    @ManyToMany
    @JoinTable(name = "speciallity_X_problem",
            joinColumns = @JoinColumn(name = "problem_id"),
            inverseJoinColumns = @JoinColumn(name  = "speciality_id"))
    private List<Speciality> specialities;
    
    @Column(name = "stimated_time", nullable = false)    
    private int stimatedTime;

}


