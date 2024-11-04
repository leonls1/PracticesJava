package ar.edu.utnfrc.sping_service_web.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String sex;

    private String birthDate;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientCompany clientCompany;

    @OneToMany(mappedBy = "client")
    private List<CarRentalDetail> details;

    public Client() {
        this.details = new ArrayList<>();
    }
}
