package javafx.incidentmanager.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import javafx.incidentmanager.model.satellite.CorporateName;
import lombok.Data;
import java.util.List;

@Entity
@Table
@Data
public class Client {
    
    private String Cuil_Cuit;
    
    @Column(name = "phone_number")
    private Long phoneNumber;
    
    private String email;
    
    @Enumerated(EnumType.STRING)
    private CorporateName corporateName;
    
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Incident> incidents;
}
