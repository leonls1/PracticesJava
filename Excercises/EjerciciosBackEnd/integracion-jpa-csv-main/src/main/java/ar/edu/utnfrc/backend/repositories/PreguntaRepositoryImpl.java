package ar.edu.utnfrc.backend.repositories;

import ar.edu.utnfrc.backend.entities.Pregunta;
import ar.edu.utnfrc.backend.repositories.interfaces.PreguntaRepository;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;


public class PreguntaRepositoryImpl extends RepositoryImpl<Pregunta, Integer> implements PreguntaRepository {
    @Override
    public Integer countRecords() {
        Query query = manager.createNamedQuery("Pregunta.count");
        return query.getFirstResult();
    }

    @Override
    public Pregunta findByDescripcion(String descripcion) {
        Query query = manager.createNamedQuery("Pregunta.findByDescripcion");
        query.setParameter("desc", descripcion);
        return (Pregunta) query.getSingleResult();
    }
}
