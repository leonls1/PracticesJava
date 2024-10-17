package ar.edu.utnfrc.backend.repositories.interfaces;

import ar.edu.utnfrc.backend.entities.Pregunta;

public interface PreguntaRepository extends Repository<Pregunta, Integer> {

    Pregunta findByDescripcion(String descripcion);
}
