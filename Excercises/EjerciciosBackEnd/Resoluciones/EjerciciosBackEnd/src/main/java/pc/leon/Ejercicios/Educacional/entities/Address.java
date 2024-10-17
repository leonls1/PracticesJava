package pc.leon.Ejercicios.Educacional.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String street;

    @Column(name = "zip_code")
    private String zipCode;

    private String city;

    private String province;

    @OneToOne
    private Student student;
}
