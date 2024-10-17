package ar.edu.utnfrc.backend.entities;

import ar.edu.utnfrc.backend.entities.compositeKey.PreguntaExamenKey;
import jakarta.persistence.*;

@Entity
@Table(name = "PreguntaExamenes")
public class PreguntaExamen {

    @EmbeddedId
    private PreguntaExamenKey preguntaExamenId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("examenId")
    @JoinColumn(name = "examen_id", referencedColumnName = "id")
    private Examen examen;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("preguntaId")
    @JoinColumn(name = "pregunta_id", referencedColumnName = "id")
    private Pregunta pregunta;
}
