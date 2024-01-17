package javafx.incidentmanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

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

    private LocalDate entryDate;

    @Column(name = "phone_number")
    private Long phoneNumber;

    private String email;

    //enum for empoyeetype   
    

}
