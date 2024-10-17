package ar.edu.utnfrc.backend.entities.compositeKey;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PreguntaOpcionKey implements Serializable {

    @Column(name = "opcion_id")
    private int opcionId;

    @Column(name = "pregunta_id")
    private int preguntaId;

    public PreguntaOpcionKey() {}

    public PreguntaOpcionKey(int opcionId, int preguntaId) {
        this.opcionId = opcionId;
        this.preguntaId = preguntaId;
    }

    public int getOpcionId() {
        return opcionId;
    }

    public void setOpcionId(int opcionId) {
        this.opcionId = opcionId;
    }

    public int getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(int preguntaId) {
        this.preguntaId = preguntaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PreguntaOpcionKey that = (PreguntaOpcionKey) o;
        return opcionId == that.opcionId && preguntaId == that.preguntaId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(opcionId, preguntaId);
    }
}
