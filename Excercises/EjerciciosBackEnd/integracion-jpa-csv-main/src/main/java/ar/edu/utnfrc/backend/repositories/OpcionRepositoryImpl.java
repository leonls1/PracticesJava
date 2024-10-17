package ar.edu.utnfrc.backend.repositories;

import ar.edu.utnfrc.backend.entities.Opcion;
import ar.edu.utnfrc.backend.repositories.interfaces.OpcionRepository;
import jakarta.persistence.Query;

public class OpcionRepositoryImpl extends RepositoryImpl<Opcion, Integer> implements OpcionRepository {
    @Override
    public Integer countRecords() {
        Query query = manager.createNamedQuery("Opcion.count");
        long res = (Long) query.getSingleResult();
        return (int) res;
    }
}
