package ar.edu.utnfrc.sping_service_web.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class ClientCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String phoneNumber;

    private String emailContact;

    @OneToMany(mappedBy = "clientCompany", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Client> clients;

    public ClientCompany() {
        this.clients = new ArrayList<>();
    }
}
