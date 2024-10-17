package ar.edu.utnfrc.backend.repositories;

import ar.edu.utnfrc.backend.entities.Direccion;
import ar.edu.utnfrc.backend.repositories.interfaces.DireccionRepository;
import jakarta.persistence.Query;


public class DireccionRepositoryImpl extends RepositoryImpl<Direccion, Integer> implements DireccionRepository {


    @Override
    public Integer countRecords() {
        Query query = manager.createNamedQuery("Direccion.count");
        return query.getFirstResult();
    }
}
