package ar.edu.utnfrc.sping_service_web.repository;

import ar.edu.utnfrc.sping_service_web.model.entities.ClientCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientCompanyRepository extends JpaRepository<ClientCompany, Long> {
}
