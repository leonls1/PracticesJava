/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package class6.model.entity;

import jakarta.persistence.CascadeType;
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

@Data
@Entity
@Table(name ="work")
public class Work {
    @Id
    @Column
    @GeneratedValue(strategy=SEQUENCE, generator="IDENTITY")  
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "service_lender")
    private Long serviceLender;
    
    @ManyToOne
    @JoinColumn(name = "service_type")
    private Long serviceType;
    
    @ManyToOne
    @JoinColumn(name = "consumer")
    private Long idConsumer;

    private Date date;
    private float price;
    private String place;
    
    @Column(name = "time_range")
    private String timeRange;
    
    @OneToMany(mappedBy = "work", cascade = CascadeType.ALL)
    private List<Qualification> qualifications ;
    
    @OneToMany(mappedBy = "work", cascade = CascadeType.ALL)
    private List<Consumer> consumer ;
    
    @OneToMany(mappedBy = "work", cascade = CascadeType.ALL)
    private List<Task> task ;
}
