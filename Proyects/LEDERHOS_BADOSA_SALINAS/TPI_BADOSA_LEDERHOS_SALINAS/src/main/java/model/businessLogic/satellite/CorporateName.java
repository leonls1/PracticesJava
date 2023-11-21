/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.businessLogic.satellite;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.SEQUENCE;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;
import model.businessLogic.entity.Client;



@Data
@Entity
@Table(name = "corporate_name")
public class CorporateName {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=SEQUENCE, generator="IDENTITY")  
    private Long id;
    
    private String description;
    
    @OneToMany(mappedBy = "client")
    private List<Client> clients;
    
    

}
