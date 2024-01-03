package com.andrius.petclinic.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.HashSet;
import java.util.Set;

/**
 * Code created by Andrius on 2020-09-26
 */
@Entity
@Getter @Setter @NoArgsConstructor
public class Veterinarian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String speciality;

    @OneToMany(mappedBy = "veterinarian",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Consult> consultSet = new HashSet<>();

    public void addConsult(Consult consult) {
        consultSet.add(consult);
        consult.setVeterinarian(this);
    }

    public void removeConsult(Consult consult) {
        consultSet.remove(consult);
        consult.setVeterinarian(null);
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
