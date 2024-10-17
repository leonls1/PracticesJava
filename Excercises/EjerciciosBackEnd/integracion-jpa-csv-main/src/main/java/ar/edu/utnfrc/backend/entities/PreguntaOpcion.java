package ar.edu.utnfrc.backend.entities;

import ar.edu.utnfrc.backend.entities.compositeKey.PreguntaOpcionKey;
import jakarta.persistence.*;

@Entity
@Table(name = "PreguntaOpciones")
public class PreguntaOpcion {

    @EmbeddedId
    private PreguntaOpcionKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("preguntaId")
    @JoinColumn(name="pregunta_id", referencedColumnName = "id")
    private Pregunta pregunta;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("opcionId")
    @JoinColumn(name = "opcion_id", referencedColumnName = "id")
    private Opcion opcion;
}
