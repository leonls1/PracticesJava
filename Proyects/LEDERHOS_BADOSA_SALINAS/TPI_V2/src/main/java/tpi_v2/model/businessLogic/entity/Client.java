/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi_v2.model.businessLogic.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Data;

@Data
@Entity
@jakarta.persistence.Table(name = "client")
public class Client {

    @Id 
    @Column(name = "CUIL_CUIT", nullable = false, unique = true)    
    private Long id;
    
    private String corporateName;
    
    private String cuitCuil;
    
    @OneToMany(mappedBy = "service")
    private List<Service> services;
}
