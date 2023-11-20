/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package class6.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name ="service")
public class Service {
    
    @ManyToOne
    @JoinColumn(name = "service_lender")
    private Long idServicelender;
    
    @ManyToOne
    @JoinColumn(name = "service_type")
    private Long typeService;
    
    
    @Column(name = "time_availability")
    private String timeAvailability;
    
    private String descrition;
    
    @Column(name = "coverage_radio")
    private int radioCoverage;
    
    
}
