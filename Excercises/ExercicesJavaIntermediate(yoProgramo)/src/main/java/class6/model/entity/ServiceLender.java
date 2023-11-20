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
@Table(name ="service_lender")
public class ServiceLender {
    @Id
    @Column
    @GeneratedValue(strategy=SEQUENCE, generator="IDENTITY")  
    private Long id;

    @ManyToOne
    @JoinColumn(name = "document_type")
    private Long docType;

    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "url_picture")
    private String urlPicture;

    @Column(name = "birth_date")
    private Date birthDate;

    private Long cuil_cuit;
    @OneToMany(mappedBy = "service_lender", cascade = CascadeType.ALL)
    private List<Service> services;
    
    @OneToMany(mappedBy = "service_lender", cascade = CascadeType.ALL)
    private List<Picture> pictures;
    
    @OneToMany(mappedBy = "service_lender", cascade = CascadeType.ALL)
    private List<Work> works;
    
    @OneToMany(mappedBy = "service_lender", cascade = CascadeType.ALL)
    private List<Contact> contacs;

}
