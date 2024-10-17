package ar.edu.utnfrc.sping_service_web.repository;

import ar.edu.utnfrc.sping_service_web.model.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
