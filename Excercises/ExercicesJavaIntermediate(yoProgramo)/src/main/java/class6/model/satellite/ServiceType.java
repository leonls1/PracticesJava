/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package class6.model.satellite;

import class6.model.entity.Picture;
import class6.model.entity.Service;
import class6.model.entity.Work;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.SEQUENCE;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name ="service_type")
public class ServiceType {
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="IDENTITY")  
    private Long id;
    private String description;
    
    @OneToMany(mappedBy = "service_type", cascade = CascadeType.ALL)
    private List<Service> services;
    
    @OneToMany(mappedBy = "service_type", cascade = CascadeType.ALL)
    private List<Picture> pictures;
    
    @OneToMany(mappedBy = "service_type", cascade = CascadeType.ALL)
    private List<Work> works;
}
