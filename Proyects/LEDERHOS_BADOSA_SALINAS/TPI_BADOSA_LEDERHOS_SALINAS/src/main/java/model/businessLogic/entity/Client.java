/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.businessLogic.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;


@Data
@Entity
@Table(name = "client")
public class Client {
    
    @Id 
    @Column(name = "CUIL_CUIT", nullable = false, unique = true)
    private String CUIL_CUIT;
    
    private String phone;
    
    private String email;
    
    @ManyToOne
    @JoinColumn(name = "corporateName")    
    private Long id_corporateName;
    
    @OneToMany(mappedBy = "incident")
    private List<Incident> incidents;
    
}