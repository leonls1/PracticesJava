package ar.edu.utnfrc.sping_service_web.repository;

import ar.edu.utnfrc.sping_service_web.model.entities.CarRental;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRentalRepository extends JpaRepository<CarRental, Long> {
    Page<CarRental> findAll(Pageable pageable);

    List<CarRental> findByPaidIsFalse();
}
