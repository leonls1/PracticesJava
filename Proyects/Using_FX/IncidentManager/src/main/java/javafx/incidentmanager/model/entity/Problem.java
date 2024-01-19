package javafx.incidentmanager.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import javafx.incidentmanager.model.satellite.ProblemType;
import lombok.Data;

@Entity
@Table
@Data
public class Problem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToMany
    private Incident incident;
    
    @ManyToMany
    private Specialty specialty;
    
    @Enumerated(EnumType.STRING)
    private ProblemType type;
    
    private String description;
    
    @Column(name = "stimated_time")
    private int stimatedTime;
}
