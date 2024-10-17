package ar.edu.utnfrc.sping_service_web.repository;

import ar.edu.utnfrc.sping_service_web.model.entities.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Page<Vehicle> findAll(Pageable pageable);
}
