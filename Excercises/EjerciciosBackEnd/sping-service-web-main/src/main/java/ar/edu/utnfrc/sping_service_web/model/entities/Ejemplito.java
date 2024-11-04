package ar.edu.utnfrc.sping_service_web.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Ejemplito {
    @Id
    private Long id;
    private String descripcion;
}
