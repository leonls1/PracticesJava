package javafx.incidentmanager.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import javafx.incidentmanager.model.satellite.EmployeeType;
import java.util.List;
import lombok.Data;

@Entity
@Table
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String surname;

    @Column(name = "birth-date")
    private LocalDate birthDate;

    @Column(name = "entry_date")
    private LocalDate entryDate;

    @Column(name = "phone_number")
    private Long phoneNumber;

    private String email;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Specialty> specialties;

    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;

}
