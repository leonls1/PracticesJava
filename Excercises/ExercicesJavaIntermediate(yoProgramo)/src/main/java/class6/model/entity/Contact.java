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
@Table(name ="contact")
public class Contact {

    @ManyToOne
    @JoinColumn(name = "service_lender")
    private Long idServiceLender;
    
    @ManyToOne
    @JoinColumn(name = "contact_type")
    private Long contactType;

    @Column(name = "description")
    private String description;
}
